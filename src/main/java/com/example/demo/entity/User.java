package com.example.demo.entity;

import com.example.demo.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userID;

    @Column(name="username")
    private String username;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_created")
    private Timestamp dateCreated;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="user_type")
    private UserType userType;

    @Column(name="user_address")
    private String userAddress;

    @Column(name="profile_pic")
    private String profilePic;

    public User() {
        super();
    }

    public User(int userID, String username, String userPassword, String firstName, String lastName, Timestamp dateCreated, String userEmail, UserType userType, String userAddress, String profilePic) {
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
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateCreated=" + dateCreated +
                ", userEmail='" + userEmail + '\'' +
                ", userType=" + userType +
                ", userAddress='" + userAddress + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
