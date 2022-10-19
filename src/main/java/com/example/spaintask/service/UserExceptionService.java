package com.example.spaintask.service;

import com.example.spaintask.exception.UserNotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionService {

    @ExceptionHandler(value = UserNotFoudException.class)
    public ResponseEntity<Object> exception(UserExceptionService exception){

        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }


}
