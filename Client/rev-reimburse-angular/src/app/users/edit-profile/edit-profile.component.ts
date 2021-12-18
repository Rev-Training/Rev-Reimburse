import { Component, OnInit } from '@angular/core';
import {User} from "../user.model";
import {Router} from "@angular/router";
import {FileUploadService} from "../../uploads/file-upload.service";
import {UsersService} from "../users.service";
import {AuthService} from "../auth.service";

class ImageSnippet {
  constructor(public src: string, public file: File) {}
}

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  updatedUser: User = new User();
  // updatedUser: User = this.authService.retrieveUser();
  // @ts-ignore
  selectedFile: ImageSnippet;


  constructor(private authService: AuthService,
              private userService: UsersService,
              private router: Router,
              private fileUploadService: FileUploadService){ }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.updatedUser = this.authService.retrieveUser();
  }

  updateUser() {
    this.userService.updateUser(this.updatedUser).subscribe({
      next: response => {
        this.router.navigate(['home'])
      },
      error: err => {

      }
    });
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
          this.updatedUser.profilePic = response;
        },
        error: err => {
        }
      })
    });

    reader.readAsDataURL(file);
  }
  retrieveUserPhoto(){
    return this.authService.retrieveUserPic();
  }


}
