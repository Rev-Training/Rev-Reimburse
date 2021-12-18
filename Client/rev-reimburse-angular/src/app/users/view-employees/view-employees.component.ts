import { Component, OnInit } from '@angular/core';
import {User} from "../user.model";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-view-users',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {

  allEmployees: User[]= [];
  errorMsg: string = '';

  constructor(private userService: UsersService) { }

  ngOnInit(): void {
    this.getAllEmployees();
  }

  getAllEmployees() {
    this.userService.getAllEmployees().subscribe({
      next: response => {
        this.allEmployees = response;
      },
      error: error => {
        this.errorMsg = 'error in getAllEmployees';
        console.log(this.errorMsg);
      }
    })
  }

}
