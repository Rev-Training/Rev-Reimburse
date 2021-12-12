package com.example.demo.pojo;

import com.example.demo.enums.UserType;

import java.sql.Timestamp;

public class UserPojo {

    private int userID;
    private String username;
    private String userPassword;
    private String firstName;
    private String lastName;
    private Timestamp dateCreated;
    private String userEmail;
    private UserType userType;
    private String userAddress;
    private String profilePic;


    public UserPojo(int userID, String username, String userPassword, String firstName,
                    String lastName, Timestamp dateCreated, String userEmail,
                    UserType userType, String userAddress, String profilePic) {
        super();
        this.userID = userID;
        this.username = username;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = dateCreated;
        this.userEmail = userEmail;
        this.userType = userType;
        this.userAddress = userAddress;
        this.profilePic = profilePic;
    }



    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


    @Override
    public String toString() {
        return "UserPojo{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userType='" + userType + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
