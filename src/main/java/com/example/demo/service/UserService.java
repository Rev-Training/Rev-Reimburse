package com.example.demo.service;

import com.example.demo.enums.UserType;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.UserPojo;

import java.util.List;

public interface UserService {
    UserPojo addUser(UserPojo user) throws ApplicationException;
    UserPojo updateUser(UserPojo user) throws ApplicationException;
    boolean deleteUser(int userID) throws ApplicationException;
    List<UserPojo> getAllUsers() throws ApplicationException;
    List<UserPojo> getUsersByType(UserType userType) throws ApplicationException;
    UserPojo getAUser(int userID) throws ApplicationException;
    UserPojo userLogin(String username, String userPassword) throws ApplicationException;
    void exitApplication();
}
