import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserLogoutComponent } from './user/user-logout/user-logout.component';
import { UserManagementComponent } from './user/user-management/user-management.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { UserInputComponent } from './user/user-input/user-input.component';
import { RequestDetailsComponent } from './request/request-details/request-details.component';
import { RequestManagementComponent } from './request/request-management/request-management.component';
import { RequestInputComponent } from './request/request-input/request-input.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserLoginComponent,
    UserLogoutComponent,
    UserManagementComponent,
    UserDetailsComponent,
    UserInputComponent,
    RequestDetailsComponent,
    RequestManagementComponent,
    RequestInputComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
