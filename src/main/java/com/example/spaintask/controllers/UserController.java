package com.example.spaintask.controllers;

import com.example.spaintask.models.userModel.User;

import com.example.spaintask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String wellcome() {

        return "Wellcome to Manging User - Service ";

    }

    @PostMapping("/adduser")
    public User addUser(@Valid @RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @RequestMapping(value = "/user/{serialNumber}", method = RequestMethod.GET)
    public ResponseEntity<Object> getData(@PathVariable("serialNumber") String serialNumber) {
        User user = userService.getUserWithSerial(serialNumber);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/user/allusers", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers() {
        List<User> userList = userService.getUsers();
        return new ResponseEntity<>(userList, HttpStatus.ACCEPTED);
    }


}

