import { Injectable } from '@angular/core';
import {User} from "./user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean = false;

  storeUser(user: User) {
    sessionStorage.setItem("userData", JSON.stringify(user));
    console.log("inside store User");
    console.log(user);
    let data: any = sessionStorage.getItem("userData");
    let rUser: User = JSON.parse(data == null ?  '' : data);
    console.log(rUser);
    this.isLoggedIn = true;
  }

  retrieveUser() {
    console.log("In retireve");
    let data: any = sessionStorage.getItem("userData");
    console.log("data: ");
    console.log(data);
    let user: User = JSON.parse(data == null ?  '' : data);
    console.log(user);
    this.isLoggedIn = data; //Will be converted to true/false based on if data was null or not
    return user;

  }

  removeUser() {
    sessionStorage.removeItem("userData");
    this.isLoggedIn = false;
  }

  retrieveUserType() {
    let data: any = sessionStorage.getItem("userData");
    let user: User = JSON.parse(data == null ?  '' : data);
    return user.userType;
  }

  retrieveUserID() {
    let data: any = sessionStorage.getItem("userData");
    let user: User = JSON.parse(data == null ?  '' : data);
    return user.userID;
  }

  retrieveUserPic() {
    let data: any = sessionStorage.getItem("userData");
    let user: User = JSON.parse(data == null ?  '' : data);
    console.log(user.profilePic);
    return user.profilePic;

  }


  constructor() { }
}
