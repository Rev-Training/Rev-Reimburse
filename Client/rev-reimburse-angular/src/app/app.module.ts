import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {HttpClientModule} from "@angular/common/http";
import {MatInputModule} from "@angular/material/input";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './users/login/login.component';
import { HomeComponent } from './users/home/home.component';
import { EditProfileComponent } from './users/edit-profile/edit-profile.component';
import { SubmitReqComponent } from './requests/submit-req/submit-req.component';
import { ViewMyRequestsComponent } from './requests/view-my-requests/view-my-requests.component';
import { ViewEmployeeRequestsComponent } from './requests/view-employee-requests/view-employee-requests.component';
import { ViewEmployeesComponent } from './users/view-employees/view-employees.component';
import { CreateNewUserComponent } from './users/create-new-user/create-new-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    EditProfileComponent,
    SubmitReqComponent,
    ViewMyRequestsComponent,
    ViewEmployeeRequestsComponent,
    ViewEmployeesComponent,
    CreateNewUserComponent
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
    BrowserAnimationsModule
    // MaterialExampleModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
