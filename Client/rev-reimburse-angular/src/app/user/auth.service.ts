import { Injectable } from '@angular/core';
import { User, UserType } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  
  isLoggedIn: boolean = false;

  cacheUser(user: User)
  {
    sessionStorage.setItem("userCache", JSON.stringify(user));
  }

  getCurrentUser(): User
  {
    let data: any = sessionStorage.getItem("userCache");
    return JSON.parse(data == null ? new User() : data);
  }

  removeCurrentUser()
  {
    sessionStorage.removeItem("userCache");
  }

  userIsManager(): boolean
  {
    let data: any = sessionStorage.getItem("userCache");
    let user: User = JSON.parse(data);
    if (data == null)
    {
      //alert("userType is null");
      return false;
    }
    else
    {
      return user.userType == UserType.MANAGER || user.userType == UserType.ADMIN;
    }
  }
}
