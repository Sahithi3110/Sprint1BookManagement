package com.cg.bookstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {

	@Id
	private int categoryId;
	private String categoryName;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Book book;
	
	public Category() {}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category(int categoryId, String categoryName, Book book) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.book = book;
	}
	
	
	
}
