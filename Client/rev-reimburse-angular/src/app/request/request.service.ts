import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRequest } from './user.request.model';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  baseURL = "http://localhost:8888/api/requests";

  constructor(private http: HttpClient) { }

  addRequestService(request: UserRequest): Observable<UserRequest>
  {
    return this.http.post<UserRequest>(this.baseURL, request);
  }

  getRequestService(requestID: number): Observable<UserRequest>
  {
    return this.http.get<UserRequest>(this.baseURL + "/id/" + requestID);
  }

  getAllRequestsService(): Observable<UserRequest[]>
  {
    return this.http.get<UserRequest[]>(this.baseURL);
  }

  getAllUserRequestsService(userID: number): Observable<UserRequest[]>
  {
    return this.http.get<UserRequest[]>(this.baseURL + "/user/" + userID);
  }

  updateRequestService(request: UserRequest, approve: boolean): Observable<UserRequest>
  {
    let approval: string = approve ? "/a/" : "/d/";
    return this.http.put<UserRequest>(this.baseURL + approval + request.reqID, request);
  }
}
