package com.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.poc.payload.ApiResposne;

@ControllerAdvice
//@ResponseBody
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiResposne> handleCustomerNotFoundException(CustomerNotFoundException ex)
	{
		System.out.println("inside global exception handler");
		ApiResposne response = new ApiResposne("Customer not found", HttpStatus.NOT_FOUND, false);
		
		return new ResponseEntity<ApiResposne>(response,HttpStatus.NOT_FOUND);
		
	}
}
