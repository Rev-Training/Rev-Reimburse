import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/user/auth.service';
import { User } from 'src/app/user/user.model';
import { UserService } from 'src/app/user/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit
{

  constructor(private authService: AuthService, private router: Router, private userService: UserService) { }

  logout: string = 'logout';
  userManage: string = 'user-management';
  requestAdd: string = 'request-add';
  requestManage: string = 'request-management';

  ngOnInit(): void
  {

  }

  currentUserName(): string
  {
    return this.authService.getCurrentUser().username;
  }

  isLoggedIn()
  {
    return this.authService.isLoggedIn;
  }

  managerLevel()
  {
    return this.authService.userIsManager();
  }

  goToMyAccount()
  {
    this.userService.userCache = this.authService.getCurrentUser();
    this.router.navigate(['user-details']);
  }

  navigate(route: string)
  {
    this.router.navigate([route]);
  }

}
