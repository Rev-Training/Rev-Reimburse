package com.example.demo.controller;

import com.example.demo.enums.UserType;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.UserPojo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")

public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping()
    UserPojo addUser(@RequestBody UserPojo user) throws ApplicationException {
        //return userService.addUser(user);
        return userService.addUser(user);
    }

    @PutMapping()
    UserPojo updateUser(@RequestBody UserPojo user) throws ApplicationException {
        //return userService.updateUser(user);
        return userService.updateUser(user);
    }

    @GetMapping()
    List<UserPojo> getAllUsers() throws ApplicationException {
        //return userService.getAllUsers();
        return userService.getAllUsers();
    }

    @GetMapping("/login")
    UserPojo login(@RequestParam(name = "username") String username, @RequestParam(name = "userPassword") String userPassword) throws ApplicationException {
        System.out.println(username);
        System.out.println(userPassword);
        return userService.userLogin(username, userPassword);
    }

    @DeleteMapping()
    boolean deleteUser(@RequestParam int userID) throws ApplicationException {
        //return userService.deleteUser(@RequestParam String username, @RequestParam String password);
        return userService.deleteUser(userID);
    }

    @GetMapping("/managers")
    List<UserPojo> getManagers() throws ApplicationException {
        //return userService.getAllUsers();
        return userService.getUsersByType(UserType.MANAGER);
    }

    @GetMapping("/employees")
    List<UserPojo> getEmployees() throws ApplicationException {
        //return userService.getAllUsers();
        return userService.getUsersByType(UserType.EMPLOYEE);
    }


}
