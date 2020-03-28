package com.cmpe275.lab2.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException ex){
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(AlreadyExistsException ex){
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.CONFLICT);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(BadRequestException ex){
		ErrorResponse err=new ErrorResponse();
		err.setMessage(ex.getMessage());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.CONFLICT);
	}
}
