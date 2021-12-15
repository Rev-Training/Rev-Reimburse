import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './users/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HomeEmployeeComponent } from './employee/home-employee/home-employee.component';
import { HomeManagerComponent } from './manager/home-manager/home-manager.component';
import {SubmitReqComponent} from "./employee/reimburse-reqs/submit-req/submit-req.component";
import {HttpClientModule} from "@angular/common/http";
import { ViewReqsComponent } from './employee/reimburse-reqs/view-reqs/view-reqs.component';
import {EditUserComponent} from "./users/edit-user/edit-user.component";
import { ViewEmployeeReqsComponent } from './manager/reimburse-reqs/view-employee-reqs/view-employee-reqs.component';
import {ViewEmployeesComponent} from "./users/view-employees/view-employees.component";
import {MatInputModule} from "@angular/material/input";
import {MaterialExampleModule} from "./material/material.module";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeEmployeeComponent,
    HomeManagerComponent,
    SubmitReqComponent,
    ViewReqsComponent,
    EditUserComponent,
    ViewEmployeeReqsComponent,
    ViewEmployeesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MaterialExampleModule
    // MaterialModule,
    // MatDatepickerModule,        // <----- import(must)
    // MatNativeDateModule        // <----- import for date formating(optional)
    // MatMomentDateModule         // <----- import for date formating adapted to more locales(optional)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
