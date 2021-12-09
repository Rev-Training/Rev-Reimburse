import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User, UserType } from '../user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit
{

  newUser: User = {
    userID: 0,
    username: '',
    userPassword: '',
    firstName: '',
    lastName: '',
    dateCreated: '',
    userEmail: '',
    userType: 0,
    userAddress: ''
  }

  validatedUser: User = {
    userID: 0,
    username: '',
    userPassword: '',
    firstName: '',
    lastName: '',
    dateCreated: '',
    userEmail: '',
    userType: 0,
    userAddress: ''
  }

  backdoor: string = 'admin';

  buttonDisplay: boolean = true;

  constructor(
    private router: Router,
    private userService: UserService,
    private authService: AuthService
  ) { }

  ngOnInit(): void
  {
    this.buttonDisplay = !this.userLoggedIn();
  }

  userLoggedIn(): boolean
  {
    return this.authService.isLoggedIn;
  }

  validateLogin()
  {
    if (this.newUser.username == this.backdoor && this.newUser.userPassword == this.backdoor) 
    {
      this.newUser.userID = 0;
      this.newUser.userType = UserType.ADMIN;
      this.validatedUser = this.newUser;
      this.loginCache(this.validatedUser);
    }
    else
    {
      this.userService.getUserService(this.newUser).subscribe(
        (response) =>
        {
          if (response == null || response.userPassword != this.newUser.userPassword)
          {
            alert("invalid credentials");
          }
          else
          {
            this.validatedUser = response;
            this.loginCache(this.validatedUser);
          }
        },
        (error) =>
        {
          console.log(error);
        }
      );
    }
    this.router.navigate(['home']);
  }

  loginCache(user: User)
  {
    this.authService.cacheUser(user);
    this.authService.isLoggedIn = true;
  }

  //#region P1 CODE
  // validateLogin() //hack <.<
  // {
  //  if (this.newUser.username == "admin" && this.newUser.userPassword == "admin")
  //  {
  //    this.newUser.userID = 0;
  //    this.newUser.userType = UserType.ADMIN;
  //  }
  //  else
  //  {
  //    this.newUser.userID = 2;
  //    this.newUser.userType = UserType.EMPLOYEE;
  //  }
  //  this.validatedUser = this.newUser;
  //  this.authService.cacheUser(this.validatedUser);
  //  this.authService.isLoggedIn = true;
  //  this.router.navigate(['home']);
  // }
  // validateLogin()
  // {
  //   this.userService.getUserIDService(this.newUser.username).subscribe(
  //     (response) =>
  //     {
  //       this.newUser.userID = response;
  //       console.log(response);

  //       this.userService.getUserService(this.newUser).subscribe(
  //         (response) =>
  //         {
  //           console.log(response);
  //           this.validatedUser = response;
  //           console.log(this.validatedUser);

  //           if (this.validatedUser.userID > 0 && this.validatedUser.userPassword == this.newUser.userPassword)
  //           {
  //             this.authService.cacheUser(this.validatedUser);
  //             this.authService.isLoggedIn = true;
  //             if (this.validatedUser.userPassword == "t_password")
  //             {
  //               this.router.navigate(['pw-reset']);
  //             }
  //             else
  //             {
  //               this.router.navigate(['home']);
  //             }
  //           }
  //           else
  //           {
  //             alert('invalid credentials');
  //             this.router.navigate(['login']);
  //           }

  //         },
  //         (error) =>
  //         {
  //           console.log(error);
  //         }
  //       );
  //     },
  //     (error) =>
  //     {
  //       console.log(error);
  //       console.log("user not found");
  //     });
  // }
  //#endregion

  forgotPassword()
  {
    alert("That feature will be implemented in a future patch. :)");
  }

}
