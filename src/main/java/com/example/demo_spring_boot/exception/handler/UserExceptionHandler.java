package com.example.demo_spring_boot.exception.handler;

import com.example.demo_spring_boot.exception.FailedToRegisterUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(FailedToRegisterUserException.class)
    public ResponseEntity<String> handleFailedToRegisterUser(FailedToRegisterUserException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
