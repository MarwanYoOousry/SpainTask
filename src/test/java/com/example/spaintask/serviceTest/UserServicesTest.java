package com.example.spaintask.serviceTest;

import com.example.spaintask.models.Status;
import com.example.spaintask.models.UserType;

import com.example.spaintask.models.serviceModel.Service;
import com.example.spaintask.models.userModel.User;
import com.example.spaintask.repository.UserRepository;
import com.example.spaintask.service.UserService;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpainTaskApplicationTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void getUsersTest() {

        Service service = new Service(1, "voda", Status.Active, false, DateTime.now().toDate());
        Service service2 = new Service(2, "voda", Status.Disactive, true, DateTime.now().toDate());
        List<Service> serviceList = new ArrayList<>();
        serviceList.add(service);
        serviceList.add(service2);


        when(userRepository.findAll()).thenReturn(Stream.of(

                new User("35Aa", "Ali", "01014700781", serviceList, UserType.normal)
                , new User("35Aa1", "Ahmed", "01146608280", serviceList, UserType.anonymous)).collect(Collectors.toList()));
        Assertions.assertEquals(2, userService.getUsers().size());
    }


    @Test
    public void getUserWithSerialNumber() {

        Service service = new Service(1, "voda", Status.Active, false, DateTime.now().toDate());
        Service service2 = new Service(2, "voda", Status.Disactive, true, DateTime.now().toDate());
        List<Service> serviceList = new ArrayList<>();
        serviceList.add(service);
        serviceList.add(service2);

        String serial = "35Aa";

        User user = new User("35Aa", "Ali", "01014700781", serviceList, UserType.normal);

        when(userRepository.findById(serial)).thenReturn(Optional.of(user));

        Assertions.assertEquals("35Aa", userService.getUserWithSerial(serial).getSerialNumber());


    }

    @Test
    public void addUser() {
        Service service = new Service(1, "voda", Status.Active, false, DateTime.now().toDate());
        Service service2 = new Service(2, "voda", Status.Disactive, true, DateTime.now().toDate());
        List<Service> serviceList = new ArrayList<>();
        serviceList.add(service);
        serviceList.add(service2);
        User user = new User("35Aa", "Ali", "01014700781", serviceList, UserType.normal);

        when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(user, userService.createUser(user));


    }


}