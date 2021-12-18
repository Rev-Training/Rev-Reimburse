import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CommonModule} from "@angular/common";
import {AdminGuard} from "./users/admin.guard";
import {LoginComponent} from "./users/login/login.component";
import {HomeComponent} from "./users/home/home.component";
import {SubmitReqComponent} from "./requests/submit-req/submit-req.component";
import {ViewMyRequestsComponent} from "./requests/view-my-requests/view-my-requests.component";
import {ViewEmployeeRequestsComponent} from "./requests/view-employee-requests/view-employee-requests.component";
import {CreateNewUserComponent} from "./users/create-new-user/create-new-user.component";
import {EditProfileComponent} from "./users/edit-profile/edit-profile.component";
import {ViewEmployeesComponent} from "./users/view-employees/view-employees.component";

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'home', component: HomeComponent},
  {path:'submit-request', component: SubmitReqComponent},
  {path:'view-my-requests', component: ViewMyRequestsComponent},
  // {path:'view-my-requests/:empID', component: ViewMyRequestsComponent},
  {path:'view-employee-requests', component: ViewEmployeeRequestsComponent},
  {path:'view-employees', component: ViewEmployeesComponent},
  {path:'create-new-user', component: CreateNewUserComponent},
  {path:'edit-profile', component: EditProfileComponent}
];

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
