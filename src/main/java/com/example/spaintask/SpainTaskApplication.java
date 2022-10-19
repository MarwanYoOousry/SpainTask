package com.example.spaintask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpainTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpainTaskApplication.class, args);
    }

}
