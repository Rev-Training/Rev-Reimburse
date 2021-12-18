import {RequestStatus} from "./request-status.enum";

export class ViewRequest {
  reqID: number = 0;
  empID: number = 0;
  firstName: string = '';
  lastName: string = '';
  description: string = '';
  cost: number = 0.00;
  purchaseDate: string = '';
  requestDate: string = '';
  status: RequestStatus = RequestStatus.None;
  receiptPic:string = '';
}


