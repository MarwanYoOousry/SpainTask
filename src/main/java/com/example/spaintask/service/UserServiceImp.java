package com.example.spaintask.service;

import com.example.spaintask.models.Status;
import com.example.spaintask.models.serviceModel.Service;
import com.example.spaintask.repository.UserRepository;
import com.example.spaintask.models.userModel.User;
import com.example.spaintask.models.UserType;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUserWithSerial(String serialNumber) {

        Optional<User> optional = userRepository.findById(serialNumber);
      if(optional.isPresent()) {
          User User = optional.get();
          return User;

      }else {

          System.out.println("No user with this SerialNumber");
        return null;}
    }


//    @Override
//    public User getUser(Integer id) {
//
//        Optional<User> optional = userRepository.findById(id);
//        User user = optional.get();
//        return user;
//    }
//
//
//    @Override
//    public boolean isUserExist(Integer serialNumber) {
//        return userRepository.existsById(serialNumber);
//    }


@Override
    public List<User> getUsers() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {

        List<Service> serviceList = newUser.getService();

        // serviceList.get(serviceList.size()-1).setDate(DateTime.now().toDate());
        serviceList.forEach(service -> service.setDate(DateTime.now().toDate()));

      //  serviceList.get(serviceList.size()-1).setStatus(serviceList.get(serviceList.size()-1)
      //           .getIsActive() ? Status.Active : Status.Disactive);

        serviceList.forEach(service -> {service.setStatus(service
                   .getIsActive() ? Status.Active : Status.Disactive);});

        newUser.setService(serviceList);

        String temp = newUser.getSerialNumber();
        char lastIndexOfSerial =temp.charAt(temp.length()-1);
        if(lastIndexOfSerial >= 48 && lastIndexOfSerial <=57 ){
            newUser.setUserType(UserType.anonymous);
        }else newUser.setUserType(UserType.normal);


        return userRepository.save(newUser);
    }
}
