export class UserRequest
{
    reqID: number = -1;
    empID: number = -1;
    description: String = '';
    cost: number = 0;
    purchaseDate: String = '';
    requestDate: String = '';
    status: RequestStatus = RequestStatus.PENDING;
}
export enum RequestStatus
{
    PENDING,
    APPROVED,
    DENIED
}