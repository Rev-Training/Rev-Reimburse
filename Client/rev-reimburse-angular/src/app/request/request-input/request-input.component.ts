import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/user/auth.service';
import { RequestService } from '../request.service';
import { UserRequest, RequestStatus } from '../user.request.model';

@Component({
  selector: 'app-request-input',
  templateUrl: './request-input.component.html',
  styleUrls: ['./request-input.component.css']
})
export class RequestInputComponent implements OnInit {

  newRequest: UserRequest = {
    reqID: 0,
    empID: 0,
    description: '',
    cost: 0,
    purchaseDate: '',
    requestDate: '',
    status: RequestStatus.PENDING
  }
  
  constructor(private requestService: RequestService,
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void
  {

  }

  submitNewRequest()
  {
    if (this.newRequest.cost >= 1.00)
    {
      this.newRequest.empID = this.authService.getCurrentUser().userID;

      this.requestService.addRequestService(this.newRequest).subscribe(
        (response) =>
        {
          if (response.cost == this.newRequest.cost)
          {
            alert("Your request for $" + response.cost + " was added successfully.");
          }
          else
          {
            alert("INTERNAL ERROR: Please try again later.");
          }
          this.cancelForm();
        },
        (error) =>
        {
          console.log(error);
        }
      );
    }
    else
    {
      alert("Amount must be greater than $1.00");
    }
  }

  cancelForm()
  {
    this.router.navigate(['home']);
  }
}
