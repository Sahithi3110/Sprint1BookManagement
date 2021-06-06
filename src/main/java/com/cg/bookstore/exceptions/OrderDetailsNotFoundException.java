package com.cg.bookstore.exceptions;

public class OrderDetailsNotFoundException extends RuntimeException{
	
	public OrderDetailsNotFoundException(String message) {
	
		super(message);
	}
	
}
