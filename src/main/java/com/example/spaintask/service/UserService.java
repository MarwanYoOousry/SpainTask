package com.example.spaintask.service;

import com.example.spaintask.models.userModel.User;

import java.util.List;


public interface UserService {


    public abstract User getUserWithSerial(String serialNumber);

//    User getUser(Integer id);

    public abstract List<User> getUsers();
    public abstract User createUser(User newUser);

//    public boolean isUserExist(Integer serialNumber);

}
