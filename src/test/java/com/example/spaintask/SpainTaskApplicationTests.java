package com.example.spaintask;

import com.example.spaintask.models.UserType;

import com.example.spaintask.models.userModel.User;
import com.example.spaintask.repository.UserRepository;
import com.example.spaintask.service.userServices.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static reactor.core.publisher.Mono.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpainTaskApplicationTests {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void getUsersTest(){


        when((Publisher<?>) userRepository.findAll()).thenReturn(Stream.of(

                new User("35Aa","Ali","01014700781", UserType.normal)
                ,new User("35Aa1","Ahmed","01146608280", UserType.anonymous)).collect(Collectors.toList()));
        Assertions.assertEquals(2,userService.getUsers().size());


    }


//    @Test
//    void contextLoads() {
//        getUsersTest();
//
//    }

}
