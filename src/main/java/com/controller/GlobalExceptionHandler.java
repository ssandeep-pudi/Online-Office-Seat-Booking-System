package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	//@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception)
	{
		return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	}

}
