package com.example.spaintask.controllers;

import com.example.spaintask.consumesoap.config.SoapClient;
import com.example.spaintask.consumesoap.stub.NumberToWords;
import com.example.spaintask.consumesoap.stub.NumberToWordsResponse;
import com.example.spaintask.consumesoap.stub.ObjectFactory;
import com.example.spaintask.models.userModel.User;

import com.example.spaintask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoggingController loggingController;
    @Autowired
    private SoapClient soapClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String wellcome() {

        loggingController.index();
        return "Wellcome to Manging User - Service ";

    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public User addUser(@Valid @RequestBody User newUser) {

        loggingController.index();

        return userService.createUser(newUser);
    }


    @RequestMapping(value = "/user/{serialNumber}", method = RequestMethod.GET)
    public ResponseEntity<Object> getData(@PathVariable("serialNumber") String serialNumber) {

        loggingController.index();
        User user = userService.getUserWithSerial(serialNumber);
        ObjectFactory objectFactory = new ObjectFactory();
        NumberToWords numberToWords =objectFactory.createNumberToWords();
        numberToWords.setUbiNum(BigInteger.valueOf(user.getAge()));
        NumberToWordsResponse response = soapClient.getWords("https://www.dataaccess.com/webservicesserver/numberconversion.wso",
                numberToWords);
        user.setAge(Integer.valueOf(response.getNumberToWordsResult()));
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/user/allusers", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers() {
        loggingController.index();
        List<User> userList = userService.getUsers();

        return new ResponseEntity<>(userList, HttpStatus.ACCEPTED);

    }


}

