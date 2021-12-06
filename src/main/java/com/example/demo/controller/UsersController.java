package com.example.demo.controller;

import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users") // optional

public class UsersController {
    @PostMapping()
    UserPojo addUser(@RequestBody UserPojo user) throws ApplicationException {
        //return userService.addUser(user);
        return user;
    }

    @PutMapping()
    UserPojo updateUser(@RequestBody UserPojo user) throws ApplicationException {
        //return userService.updateUser(user);
        return user;
    }

    @GetMapping()
    List<UserPojo> getAllUsers() throws ApplicationException {
        //return userService.getAllUsers();
        return null;
    }

    @GetMapping("/login")
    UserPojo login() throws ApplicationException {
        //return userService.login(@RequestParam String username, @RequestParam String password);
        return null;
    }

    @DeleteMapping()
    boolean deleteUser() throws ApplicationException {
        //return userService.deleteUser(@RequestParam String username, @RequestParam String password);
        return false;
    }

}
