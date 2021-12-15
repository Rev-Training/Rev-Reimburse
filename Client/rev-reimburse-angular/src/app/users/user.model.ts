export class User {
  userID: number = 0;
  username: string = '';
  userPassword: string = '';
  firstName: string = '';
  lastName: string = '';
  dateCreated: string = '';
  userEmail: string = '';
  userType: UserType = UserType.None;
  userAddress: string = '';
  profilePic: string = '';
}

export enum UserType {
  None,
  ADMIN = "ADMIN",
  MANAGER = "MANAGER",
  EMPLOYEE = "EMPLOYEE"

}
