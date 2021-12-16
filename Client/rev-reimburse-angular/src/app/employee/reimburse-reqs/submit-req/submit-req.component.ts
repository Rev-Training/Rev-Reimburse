import {Component, OnInit} from '@angular/core';
import {RequestService} from "../requests.service";
import {Router} from "@angular/router";
import {Request, RequestStatus} from "../request.model";
import {AuthService} from "../../../users/auth.service";
import {MatInputModule} from "@angular/material/input";
import {MatFormField} from "@angular/material/form-field";
import {FileUploadService} from "../../../file-upload.service";

class ImageSnippet {
  constructor(public src: string, public file: File) {}
}


@Component({
  selector: 'app-submit-req',
  templateUrl: './submit-req.component.html',
  styleUrls: ['./submit-req.component.css']
})
export class SubmitReqComponent implements OnInit {

  newReq: Request = new Request();
  picker: any;
  // @ts-ignore
  selectedFile: ImageSnippet;


  constructor(private requestsService: RequestService,
              private router: Router,
              private authService: AuthService,
              private fileUploadService: FileUploadService) { }

  ngOnInit(): void {
  }

  addRequest() {
    this.newReq.empID = this.authService.retrieveUserID();
    this.newReq.status = RequestStatus.PENDING;
    this.newReq.purchaseDate = this.picker;
    console.log(this.picker);
    console.log(this.newReq);
    if(this.newReq.receiptPic != '') {
      this.requestsService.addRequestService(this.newReq).subscribe({
        next: response => {
          this.router.navigate(['home-employee']);
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
          this.newReq.receiptPic = response;
        },
        error: err => {
          console.log("inside errrrrr");
          console.log(err);
        }
      })
    });

    reader.readAsDataURL(file);
  }

}
