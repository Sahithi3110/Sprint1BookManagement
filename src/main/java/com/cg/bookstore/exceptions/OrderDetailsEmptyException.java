package com.cg.bookstore.exceptions;

public class OrderDetailsEmptyException extends RuntimeException{
	
	public OrderDetailsEmptyException(String message) {
		
		super(message);
	}

}
