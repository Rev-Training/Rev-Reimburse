package com.example.demo.entity;

//import com.example.demo.converters.RequestStatusConverter;
//import com.example.demo.converters.UserTypeConverter;
import com.example.demo.enums.UserType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userID;

    @OneToMany(mappedBy = "user")
    private Set<ViewRequest> viewRequests;

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

    @Enumerated(EnumType.STRING)
    @Column(name="user_type")
//    @Convert(converter = UserTypeConverter.class)
    private UserType userType;

    @Column(name="user_address")
    private String userAddress;

    @Column(name="profile_pic")
    private String profilePic;

    @Column(name="user_removed")
    private boolean userRemoved;

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
        this.userRemoved = false;
    }

    public User(int userID, String username, String userPassword, String firstName, String lastName, Timestamp dateCreated, String userEmail, UserType userType, String userAddress, String profilePic, boolean userRemoved) {
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
        this.userRemoved = userRemoved;
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

    public boolean isUserRemoved() {
        return userRemoved;
    }

    public void setUserRemoved(boolean userRemoved) {
        this.userRemoved = userRemoved;
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
