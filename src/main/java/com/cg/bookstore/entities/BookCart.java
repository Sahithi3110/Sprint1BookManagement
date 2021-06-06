package com.cg.bookstore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookCart {
	
	@Id	
	private String title;
	
	private double price;
	private int quantity;
	public BookCart() {}

		
	public BookCart( String title, double price, int quantity) {
		super();
		
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}


	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
