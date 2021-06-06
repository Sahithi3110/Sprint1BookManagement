package com.cg.bookstore.exceptions;

public class OrderNotFoundForAdminException extends RuntimeException {
	
	public OrderNotFoundForAdminException(String message) {
		
		super(message);
	}

}
