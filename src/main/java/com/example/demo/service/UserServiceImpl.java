package com.example.demo.service;

import com.example.demo.dao.UserRepositoryDao;
import com.example.demo.entity.User;
import com.example.demo.enums.UserType;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepositoryDao userRepositoryDao;

    @Override
    public UserPojo addUser(UserPojo user) throws ApplicationException {
        User newUser = new User(user.getUserID(), user.getUsername(), user.getUserPassword(), user.getFirstName(), user.getLastName(), user.getUserEmail(), user.getUserType(), user.getUserAddress(), user.getProfilePic());
        User returnUser = userRepositoryDao.saveAndFlush(newUser);
        user.setUserID(returnUser.getUserID());
        return user;
    }

    @Override
    public UserPojo updateUser(UserPojo user) throws ApplicationException {
        User updateUser = new User(user.getUserID(), user.getUsername(), user.getUserPassword(), user.getFirstName(), user.getLastName(), user.getDateCreated(), user.getUserEmail(), user.getUserType(), user.getUserAddress(), user.getProfilePic());
        User returnUser = userRepositoryDao.save(updateUser);
        return user;
    }

    @Override
    public boolean deleteUser(int userID) throws ApplicationException {
        User userDeleting = userRepositoryDao.getById(userID);
        userDeleting.setUserRemoved(true);
        userRepositoryDao.save(userDeleting);
        return true;
    }

    @Override
    public List<UserPojo> getAllUsers() throws ApplicationException {
        List<User> allUsersEntity = this.userRepositoryDao.findByUserRemovedIsFalse();
        List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();

        allUsersEntity.forEach((user) -> {
            UserPojo userPojo = new UserPojo(user.getUserID(), user.getUsername(), "********", user.getFirstName(), user.getLastName(), user.getDateCreated(), user.getUserEmail(), user.getUserType(), user.getUserAddress(), user.getProfilePic());
            allUsersPojo.add(userPojo);
        });
        return allUsersPojo;
    }

    @Override
    public List<UserPojo> getUsersByType(UserType userType) throws ApplicationException {
        List<User> allUsersEntity = this.userRepositoryDao.findByUserTypeAndUserRemovedIsFalse(userType);
        List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();

        allUsersEntity.forEach((user) -> {
            UserPojo userPojo = new UserPojo(user.getUserID(), user.getUsername(), "********", user.getFirstName(), user.getLastName(), user.getDateCreated(), user.getUserEmail(), user.getUserType(), user.getUserAddress(), user.getProfilePic());
            allUsersPojo.add(userPojo);
        });
        return allUsersPojo;
    }

    @Override
    public UserPojo getAUser(int userID) throws ApplicationException {
        UserPojo userPojo = null;

        Optional<User> optional = this.userRepositoryDao.findById(userID);
        if(optional.isPresent()) {
            User user = optional.get();
            userPojo = new  UserPojo(user.getUserID(), user.getUsername(), user.getUserPassword(), user.getFirstName(), user.getLastName(), user.getDateCreated(), user.getUserEmail(), user.getUserType(), user.getUserAddress(), user.getProfilePic());
        }
        return userPojo;
    }

    @Override
    public UserPojo userLogin(String username, String userPassword) throws ApplicationException {
        UserPojo userPojo = null;

        Optional<User> optional = Optional.ofNullable(this.userRepositoryDao.findByUsernameAndUserPassword(username, userPassword));
        if(optional.isPresent()) {
            User user = optional.get();
            userPojo = new  UserPojo(user.getUserID(), user.getUsername(), user.getUserPassword(), user.getFirstName(), user.getLastName(), user.getDateCreated(), user.getUserEmail(), user.getUserType(), user.getUserAddress(), user.getProfilePic());
        }
        return userPojo;
    }

    @Override
    public void exitApplication() {

    }
}
