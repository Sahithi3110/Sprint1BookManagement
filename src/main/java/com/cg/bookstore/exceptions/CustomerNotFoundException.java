package com.cg.bookstore.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String message) {
		
		super(message);
	}

}
