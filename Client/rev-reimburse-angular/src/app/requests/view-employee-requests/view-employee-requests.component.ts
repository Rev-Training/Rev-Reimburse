

import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ViewRequest} from "../view-request.model";
import {AuthService} from "../../users/auth.service";
import {RequestStatus} from "../request-status.enum";
import {RequestService} from "../request.service";

@Component({
  selector: 'app-view-reqs',
  templateUrl: './view-employee-requests.component.html',
  styleUrls: ['./view-employee-requests.component.css']
})
export class ViewEmployeeRequestsComponent implements OnInit {

  allReqs: ViewRequest[] = [];
  selectedReqs: ViewRequest[] = [];

  errorMsg: string = '';

  constructor(private requestService: RequestService,
              private router: Router,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.loadRequests();
  }



  loadRequests() {
    this.requestService.getAllReqs().subscribe({
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

  approveRequest(req: ViewRequest) {
    req.status = RequestStatus.APPROVED;
    this.requestService.updateRequest(req).subscribe({
      next: response => {
        console.log('success');
      },
      error: error => {
        this.errorMsg = 'something is wrong in approve requests';
        console.log(this.errorMsg);
      }
    });
  }

  denyRequest(req: ViewRequest) {
    req.status = RequestStatus.DENIED;
    this.requestService.updateRequest(req).subscribe({
      next: response => {
        console.log('success');
      },
      error: error => {
        this.errorMsg = 'something is wrong in deny requests';
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
