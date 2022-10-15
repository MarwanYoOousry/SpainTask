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


    @RequestMapping("/")
    public String wellcome() {

        return "Wellcome to Manging User - Service ";

    }
    @RequestMapping(value = "/user/allusers",method =RequestMethod.GET )
    public ResponseEntity<Object> getUsers(){
        List<User> userList = userService.getUsers();
        return new ResponseEntity<>(userList,HttpStatus.ACCEPTED);

    }





}

