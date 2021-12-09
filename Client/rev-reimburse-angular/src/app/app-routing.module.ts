import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { RequestDetailsComponent } from './request/request-details/request-details.component';
import { RequestInputComponent } from './request/request-input/request-input.component';
import { RequestManagementComponent } from './request/request-management/request-management.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { UserInputComponent } from './user/user-input/user-input.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserLogoutComponent } from './user/user-logout/user-logout.component';
import { UserManagementComponent } from './user/user-management/user-management.component';

const routes: Routes = [
  { path: 'login', pathMatch: 'full', component: UserLoginComponent },
  { path: '', pathMatch: 'full', component: UserLoginComponent },
  { path: 'user-add', component: UserInputComponent },
  { path: 'logout', component: UserLogoutComponent },
  { path: 'home', pathMatch: 'full', component: HomeComponent },
  { path: 'user-management', component: UserManagementComponent },
  { path: 'request-management', component: RequestManagementComponent },
  { path: 'user-details', component: UserDetailsComponent },
  { path: 'request-details', component: RequestDetailsComponent },
  { path: 'request-add', component: RequestInputComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
