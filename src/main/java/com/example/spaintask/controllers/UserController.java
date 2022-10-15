package com.example.spaintask.controllers;

import com.example.spaintask.models.userModel.User;

import com.example.spaintask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/")
    public String wellcome() {

        return "Wellcome to Manging User - Service ";

    }

    @PostMapping("/adduser")
    public User addUser(@Valid @RequestBody User newUser){
        return userService.createUser(newUser);
    }



}

