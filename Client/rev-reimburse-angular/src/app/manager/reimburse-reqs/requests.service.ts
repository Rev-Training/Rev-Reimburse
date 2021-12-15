import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {ViewRequest} from "./request.model";


@Injectable({
  providedIn: 'root'
})
export class ViewRequestService {

  baseUrl = "/api/manager-reqs";

  constructor(private http: HttpClient) { }

  getAllReqs(): Observable<ViewRequest[]>{
    return this.http.get<ViewRequest[]>(this.baseUrl);
  }

  getAllEmpReqs(employeeID: number): Observable<ViewRequest[]>{
    return this.http.get<ViewRequest[]>(this.baseUrl + "/" + employeeID);
  }

  updateRequest(request: ViewRequest): Observable<ViewRequest>{
    return this.http.put<ViewRequest>(this.baseUrl, request);
  }

}
