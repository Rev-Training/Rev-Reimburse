import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRequest, RequestStatus } from './user.request.model';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  baseURL: string = "/api";
  employee: string = "/employee-reqs";
  manager: string = "/manager-reqs";

  requestCache: UserRequest = {
    reqID: 0,
    empID: 0,
    description: '',
    cost: 0,
    purchaseDate: '',
    requestDate: '',
    status: RequestStatus.PENDING
  }

  constructor(private http: HttpClient) { }

  addRequestService(request: UserRequest): Observable<UserRequest>
  {
    return this.http.post<UserRequest>(this.baseURL + this.employee, request);
  }

  // getRequestService(requestID: number): Observable<UserRequest>
  // {
  //   return this.http.get<UserRequest>(this.baseURL + "/id/" + requestID);
  // }

  getAllRequestsService(): Observable<UserRequest[]>
  {
    return this.http.get<UserRequest[]>(this.baseURL + this.manager);
  }

  getPendingRequestsService()
  {
    return this.http.get<UserRequest[]>(this.baseURL + this.manager + "/pending");
  }

  getApprovedRequestsService()
  {
    return this.http.get<UserRequest[]>(this.baseURL + this.manager + "/approved");
  }

  getDeniedRequestsService()
  {
    return this.http.get<UserRequest[]>(this.baseURL + this.manager + "/denied");
  }

  getAllUserRequestsService(userID: number): Observable<UserRequest[]>
  {
    return this.http.get<UserRequest[]>(this.baseURL + this.employee + "/" + userID);
  }

  updateRequestService(request: UserRequest): Observable<UserRequest>
  {
    return this.http.put<UserRequest>(this.baseURL + this.manager, request);
  }

}
