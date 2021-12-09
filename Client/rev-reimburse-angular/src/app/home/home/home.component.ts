import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/user/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  logout: string = 'logout';
  userManage: string = 'user-management';
  requestAdd: string = 'request-add';
  requestManage: string = 'request-management';

  ngOnInit(): void
  {

  }

  currentUserID(): number
  {
    return this.authService.getCurrentUser().userID;
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

  goToUserDetails(userID: any)
  {
    this.router.navigate(['user-details', userID]);
  }

  navigate(route: string)
  {
    this.router.navigate([route]);
  }

}
