package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IncorrectLoginCredentialsException extends RuntimeException {
 
    private static final long serialVersionUID = 1L;
 
    public IncorrectLoginCredentialsException(String message) {
        super(message);
    }
}