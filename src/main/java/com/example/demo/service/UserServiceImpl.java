package com.example.demo.service;

import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.UserPojo;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public UserPojo addUser(UserPojo user) throws ApplicationException {
        return null;
    }

    @Override
    public UserPojo updateUser(UserPojo user) throws ApplicationException {
        return null;
    }

    @Override
    public boolean deleteUser(int userID) throws ApplicationException {
        return false;
    }

    @Override
    public List<UserPojo> getAllUsers() throws ApplicationException {
        return null;
    }

    @Override
    public UserPojo getAUser(int userID) throws ApplicationException {
        return null;
    }

    @Override
    public void exitApplication() {

    }
}
