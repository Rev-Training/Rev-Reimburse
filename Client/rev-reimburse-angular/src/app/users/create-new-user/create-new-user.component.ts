
import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MatInputModule} from "@angular/material/input";
import {MatFormField} from "@angular/material/form-field";
import {FileUploadService} from "../../uploads/file-upload.service";
import {User, UserType} from "../user.model";
import {UsersService} from "../users.service";
import {AuthService} from "../auth.service";

class ImageSnippet {
  constructor(public src: string, public file: File) {}
}


@Component({
  selector: 'app-submit-req',
  templateUrl: './create-new-user.component.html',
  styleUrls: ['./create-new-user.component.css']
})
export class CreateNewUserComponent implements OnInit {

  newUser: User = new User();
  picker: any;
  // @ts-ignore
  selectedFile: ImageSnippet;


  constructor(private usersService: UsersService,
              private router: Router,
              private authService: AuthService,
              private fileUploadService: FileUploadService) { }

  ngOnInit(): void {
  }

  addUser() {
    this.newUser.userType = UserType.EMPLOYEE;
    console.log(this.picker);
    console.log(this.newUser);
    if(this.newUser.profilePic != '') {
      this.usersService.addNewUser(this.newUser).subscribe({
        next: response => {
          this.router.navigate(['home']);
        },
        error: err => {

        }
      });
    }
  }

  uploadImage(imageInput: any) {
    console.log("upload started");
    const file: File = imageInput.files[0];
    const reader = new FileReader();
    let imageLink: string;
    reader.addEventListener('load', (event: any) => {
      console.log("inside listener");

      this.selectedFile = new ImageSnippet(event.target.result, file);

      this.fileUploadService.onUpload(this.selectedFile.file).subscribe({
        next: async (response) => {
          console.log("inside next");
          console.log(response);
          this.newUser.profilePic = response;
        },
        error: err => {
        }
      })
    });

    reader.readAsDataURL(file);
  }

}
