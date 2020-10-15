package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.exception.InvalidFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminExceptionHandler {

    @ExceptionHandler
    private ResponseEntity handleInvalidFieldException(InvalidFieldException e){
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

}
