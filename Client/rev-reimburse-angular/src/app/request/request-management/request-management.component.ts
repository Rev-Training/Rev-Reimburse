import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/user/auth.service';
import { RequestService } from '../request.service';
import { RequestStatus, UserRequest } from '../user.request.model';

@Component({
  selector: 'app-request-management',
  templateUrl: './request-management.component.html',
  styleUrls: ['./request-management.component.css']
})
export class RequestManagementComponent implements OnInit {

  allRequests: UserRequest[] = [];
  pendingStatus: RequestStatus = RequestStatus.PENDING;

  constructor(private requestService: RequestService,
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void
  {
    this.requestService.getAllRequestsService().subscribe(
      (response) =>
      {
        this.allRequests = response;
      },
      (error) =>
      {
        console.log(error);
      }
    );
  }

  goToRequestEdit(request: UserRequest)
  {
    this.requestService.requestCache = request;
    this.router.navigate(['request-details']);
  }


}
