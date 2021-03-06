import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "./users/auth.service";
import {Location} from "@angular/common";
import {UserType} from "./users/user.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  title = 'Reimbursement App';

  inHome: boolean = true;
  constructor(private router: Router,
              private authService: AuthService,
              private location: Location) {
    router.events.subscribe(val => {
      if (location.path() == "" || location.path() == "/home" ) {
        this.inHome = true;
      } else {
        this.inHome = false;

      }
    });

  }

  ngOnInit() {

  }




  goHome() {
    if(this.authService.retrieveUserType().valueOf() === UserType.MANAGER.valueOf()) {
      this.router.navigate(["home"]);
    } else if(this.authService.retrieveUserType().valueOf() === UserType.EMPLOYEE.valueOf() || this.authService.retrieveUserType().valueOf() === UserType.ADMIN.valueOf()) {
      this.router.navigate(["home"]);
    }
  }
}
