export class UserRequest
{
    reqID: number = -1;
    empID: number = -1;
    description: string = '';
    cost: number = 0;
    purchaseDate: string = '';
    requestDate: string = '';
    status: RequestStatus = RequestStatus.PENDING;
}
export enum RequestStatus
{
    PENDING,
    ACCEPTED,
    DENIED
}
