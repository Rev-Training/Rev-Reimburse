import {Component, OnInit} from '@angular/core';
import {User, UserType} from "../user.model";
import {UserService} from "../user.service";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newUser: User = new User();

  errMsg: String = '';

  constructor(private userService: UserService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  validateLogin() {
    let validatedUser: User;

    this.userService.newValidateUser(this.newUser).subscribe({
      next: response => {
        validatedUser = response;
        console.log("user type:" + validatedUser.userType);
        console.log("user type:" + UserType.EMPLOYEE);
        console.log(validatedUser.userType == UserType.EMPLOYEE);
        console.log(validatedUser);
        if (validatedUser.userType != null) {
          this.authService.storeUser(validatedUser);
        }
        if(validatedUser.userType.valueOf() === UserType.EMPLOYEE.valueOf()) {
          console.log("start inside employee if statement");
          this.router.navigate(['home-employee']);
          console.log(" end inside employee if statement");
        } else if(validatedUser.userType.valueOf() === UserType.MANAGER.valueOf()) {
          this.router.navigate(["home-manager"]);
        }

      },
      error: err => {
        this.errMsg = 'Error in Validate Login';
        console.log(this.errMsg);
      }
    });

  }


}
