import { UserRequest } from "./user.request.model";

export class UserRequestView extends UserRequest
{
    empFirstName: String = '*john*';
    empLastName: String = '*doe*';
}