import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {ViewRequest} from "./view-request.model";


@Injectable({
  providedIn: 'root'
})
export class RequestService {

  employeeUrl = "/api/employee-reqs";
  managerUrl = "/api/manager-reqs";

  constructor(private http: HttpClient) { }

  addRequestService(newReq: ViewRequest): Observable<ViewRequest> {
    return this.http.post<ViewRequest>(this.employeeUrl, newReq);
  }

  // getAllEmpReqs(employeeID: number): Observable<ViewRequest[]>{
  //   return this.http.get<ViewRequest[]>(this.employeeUrl + "/" + employeeID);
  // }

  getAllReqs(): Observable<ViewRequest[]>{
    return this.http.get<ViewRequest[]>(this.managerUrl);
  }

  getAllEmpReqs(employeeID: number): Observable<ViewRequest[]>{
    return this.http.get<ViewRequest[]>(this.managerUrl + "/" + employeeID);
  }

  updateRequest(request: ViewRequest): Observable<ViewRequest>{
    return this.http.put<ViewRequest>(this.managerUrl, request);
  }


}
