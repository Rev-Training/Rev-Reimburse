import {Component, OnInit} from '@angular/core';
import {ViewRequestService} from "../requests.service";
import {AuthService} from "../../../users/auth.service";
import {Router} from "@angular/router";
import {ViewRequest, RequestStatus} from "../request.model";

@Component({
  selector: 'app-view-employee-reqs',
  templateUrl: './view-employee-reqs.component.html',
  styleUrls: ['./view-employee-reqs.component.css']
})
export class ViewEmployeeReqsComponent implements OnInit {

  allReqs: ViewRequest[] = [];
  selectedReqs: ViewRequest[] = [];
  filteredReqs: ViewRequest[] = [];
  filterElement: String = '';
  filterQuery: String = '';

  errorMsg: string = '';

  constructor(private viewRequestService: ViewRequestService,
              private router: Router,
              private authService: AuthService) { }

  ngOnInit(): void {
    this.loadRequests();
  }

  loadRequests() {
    this.viewRequestService.getAllReqs().subscribe({
      next: response => {
        this.allReqs = response;
        this.pendingStatus();

      },
      error: error => {
        this.errorMsg = 'something is wrong in loadAllRequests';
        console.log(this.errorMsg);
      }
    });
  }

  // filter



  approveRequest(req: ViewRequest) {
    req.status = RequestStatus.APPROVED;
    this.viewRequestService.updateRequest(req).subscribe({
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
    this.viewRequestService.updateRequest(req).subscribe({
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
