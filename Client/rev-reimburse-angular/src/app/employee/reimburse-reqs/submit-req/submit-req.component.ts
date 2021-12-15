import {Component, OnInit} from '@angular/core';
import {RequestService} from "../requests.service";
import {Router} from "@angular/router";
import {Request, RequestStatus} from "../request.model";
import {AuthService} from "../../../users/auth.service";
import {MatInputModule} from "@angular/material/input";
import {MatFormField} from "@angular/material/form-field";

@Component({
  selector: 'app-submit-req',
  templateUrl: './submit-req.component.html',
  styleUrls: ['./submit-req.component.css']
})
export class SubmitReqComponent implements OnInit {

  newReq: Request = new Request();
  picker: any;


  constructor(private requestsService: RequestService,
              private router: Router,
              private authService: AuthService) { }

  ngOnInit(): void {
  }

  addRequest() {
    this.newReq.empID = this.authService.retrieveUserID();
    this.newReq.status = RequestStatus.PENDING;
    this.newReq.purchaseDate = this.picker;
    console.log(this.picker);
    console.log(this.newReq);
    this.requestsService.addRequestService(this.newReq).subscribe({
      next: response => {
        this.router.navigate(['home-employee']);
      },
      error: err => {

      }
    });
  }

}
