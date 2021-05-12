package com.cg.bookstore.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
    
    @NotNull
    @Size(min=1,message="required")  
	private String title;
    
    @NotNull
    @Size(min=1,message="required")  
	private String author;
    
	private String description;
	private String isbn;
	
	@DecimalMin(value = "20.0")
	private double price;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Please provide a date.")
	private LocalDate publishDate;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Please provide a date.")
	private LocalDate lastUpdatedOn;
	
	
	 @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="book")
	 private Category category;
	 
	public Book() {}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
	public Book(int bookId, @NotNull @Size(min = 1, message = "required") String title,
			@NotNull @Size(min = 1, message = "required") String author, String description, String isbn,
			@DecimalMin("20.0") double price, @NotNull(message = "Please provide a date.") LocalDate publishDate,
			@NotNull(message = "Please provide a date.") LocalDate lastUpdatedOn, Category category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdatedOn = lastUpdatedOn;
		this.category = category;
	}
	
	
	
	
}
