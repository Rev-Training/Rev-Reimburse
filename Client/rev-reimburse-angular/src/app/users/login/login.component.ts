import {Component, OnInit} from '@angular/core';
import {User, UserType} from "../user.model";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  newUser: User = new User();

  errMsg: String = '';

  constructor(private usersService: UsersService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  validateLogin() {
    let validatedUser: User;

    this.usersService.newValidateUser(this.newUser).subscribe({
      next: response => {
        validatedUser = response;
        console.log("user type:" + validatedUser.userType);
        console.log("user type:" + UserType.EMPLOYEE);
        console.log(validatedUser.userType == UserType.EMPLOYEE);
        console.log(validatedUser);
        if (validatedUser.userType != null) {
          this.authService.storeUser(validatedUser);
        }
        if(validatedUser.userType.valueOf() != UserType.None.valueOf()) {
          console.log("start inside home if statement");
          this.router.navigate(['home']);
          console.log(" end inside home if statement");
        } else{
          console.log("User type not found");
        }
      },
      error: err => {
        this.errMsg = 'Error in Validate Login';
        console.log(this.errMsg);
      }
    });

  }


}
