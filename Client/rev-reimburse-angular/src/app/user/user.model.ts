export class User
{
    userID: number = -1;
    username: string = '*deafult*';
    userPassword: string = '*default*';
    firstName: string = '*john*';
    lastName: string = '*doe*';
    dateCreated: string = '';
    userEmail: string = '@';
    userType: UserType = UserType.EMPLOYEE;
    userAddress: string = '[@]';
}

export enum UserType
{
    EMPLOYEE,
    MANAGER,
    ADMIN
}