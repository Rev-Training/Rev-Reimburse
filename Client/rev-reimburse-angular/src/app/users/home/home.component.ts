import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth.service";
import { UserType } from "../user.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  isLoggedIn(){
    return this.authService.isLoggedIn;
  }

  retrieveUserType(){
    return this.authService.retrieveUserType();
  }

  retrieveUserPhoto(){
    return this.authService.retrieveUserPic();
  }

  logOut() {
    this.authService.removeUser();
  }

}
