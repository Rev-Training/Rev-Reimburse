import { Injectable } from '@angular/core';
import {User} from "./user.model";
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import {ViewRequest} from "../requests/view-request.model";


@Injectable({
  providedIn: 'root'
})

export class UsersService {

  baseUrl = "/api/users";

  constructor(private http: HttpClient ) { }


  getAllEmployees(): Observable<User[]>{
    return this.http.get<User[]>(this.baseUrl + '/employees');
  }

  updateUser(user: User): Observable<User>{
    return this.http.put<User>(this.baseUrl, user);
  }

  addNewUser(user: User): Observable<User>{
    return this.http.post<User>(this.baseUrl, user);
  }


  newValidateUser(user: User): Observable<User>{
    // consume endpoint to validate the user
    return this.http.get<User>(this.baseUrl + '/login', {
      params: {
        username: user.username,
        userPassword: user.userPassword
      }
    });
  }


}
