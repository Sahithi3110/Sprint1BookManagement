package com.cg.bookstore.exceptions;

public class OrderNotFoundForCustomerException extends RuntimeException{
	
	public OrderNotFoundForCustomerException(String message) {
		
		super(message);
	}

}
