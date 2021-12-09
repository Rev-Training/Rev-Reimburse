package com.example.demo.controller;

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
    UserPojo login() throws ApplicationException {
//        return userService.login(@RequestParam String username, @RequestParam String password);
    }

    @DeleteMapping()
    boolean deleteUser() throws ApplicationException {
        //return userService.deleteUser(@RequestParam String username, @RequestParam String password);
        return false;
    }

}
