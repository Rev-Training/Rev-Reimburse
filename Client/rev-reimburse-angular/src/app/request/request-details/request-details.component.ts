import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/user/user.service';
import { RequestService } from '../request.service';
import { UserRequest, RequestStatus } from '../user.request.model';

@Component({
  selector: 'app-request-details',
  templateUrl: './request-details.component.html',
  styleUrls: ['./request-details.component.css']
})
export class RequestDetailsComponent implements OnInit {

  currentRequest: UserRequest = {
    reqID: 0,
    empID: 0,
    description: '',
    cost: 0,
    purchaseDate: '',
    requestDate: '',
    status: RequestStatus.PENDING,
  }

  requestUserName: string = '';
  displayRequest: boolean = false;
  confirmRequestEditButtons: boolean = false;
  pendingApproval: boolean = false;

  constructor(private requestService: RequestService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private userService: UserService) { }

  ngOnInit(): void
  {
    this.confirmRequestEditButtons = false;
    this.displayRequest = false;

    this.currentRequest = this.requestService.requestCache;
    this.displayRequest = true;

    // let recievedRequestID: any = this.activatedRoute.snapshot.paramMap.get("sentRequestID");
    // console.log(this.activatedRoute.snapshot.paramMap.get("sentRequestID"));
    // this.requestService.getRequestService(recievedRequestID).subscribe(
    //   (response) =>
    //   {
    //     this.currentRequest = response;
    //     this.userService.getUserByIDService(this.currentRequest.empID).subscribe(
    //       (response) =>
    //       {
    //         this.requestUserName = response.username;
    //       },
    //       (error) =>
    //       {
    //         console.log(error);
    //       })
    //     this.displayRequest = true;
    //   },
    //   (error) =>
    //   {
    //     console.log(error);
    //   }
    // );
  }

  confirmRequestEdit(approval: boolean)
  {
    this.confirmRequestEditButtons = true;
    this.pendingApproval = approval;
  }

  cancelRequestEdit()
  {
    this.confirmRequestEditButtons = false;
  }

  goToAllRequests()
  {
    this.router.navigate(['request-management']);
  }

  updateRequest()
  {
    this.requestService.updateRequestService(this.currentRequest).subscribe(
      (response) =>
      {
        let userAlert: string = "Request #" + response.reqID + " has been " + (this.pendingApproval ? "approved." : "denied.");
        alert(userAlert);
        this.displayRequest = false;
        this.router.navigate(['request-management']);
      },
      (error) =>
      {
        console.log(error);
      }
    );
  }
}
