package com.poc.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	private String message;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	
}
