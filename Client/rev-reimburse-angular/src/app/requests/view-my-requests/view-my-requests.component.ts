import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ViewRequest} from "../view-request.model";
import {AuthService} from "../../users/auth.service";
import {RequestStatus} from "../request-status.enum";
import {RequestService} from "../request.service";

@Component({
  selector: 'app-view-reqs',
  templateUrl: './view-my-requests.component.html',
  styleUrls: ['./view-my-requests.component.css']
})
export class ViewMyRequestsComponent implements OnInit {

  allReqs: ViewRequest[] = [];
  // pendingReqs: ViewRequest[] = [];
  // approvedReqs: ViewRequest[] = [];
  // deniedReqs: ViewRequest[] = [];
  selectedReqs: ViewRequest[] = [];

  errorMsg: string = '';

  constructor(private requestService: RequestService,
              private router: Router,
              private authService: AuthService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let param: any = this.activatedRoute.snapshot.paramMap.get("empID");
    console.log(param);
    console.log("Stuff");
    this.loadRequests();
  }



  loadRequests() {
    console.log(this.authService.retrieveUser());
    this.requestService.getAllEmpReqs(this.authService.retrieveUserID()).subscribe({
      next: response => {
        this.allReqs = response;
        this.pendingStatus()
        console.log(this.allReqs);

      },
      error: error => {
        this.errorMsg = 'something is wrong in loadAllRequests';
        console.log(this.errorMsg);
      }
    });
  }

  pendingStatus() {
    this.selectedReqs = this.allReqs.filter((element) => element.status == RequestStatus.PENDING)
  }
  approvedStatus() {
    this.selectedReqs = this.allReqs.filter((element) => element.status == RequestStatus.APPROVED)
  }
  deniedStatus() {
    this.selectedReqs = this.allReqs.filter((element) => element.status == RequestStatus.DENIED)
  }


}
