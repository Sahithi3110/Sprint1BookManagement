package com.cg.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.service.IBookService;

@SpringBootTest
public class BookModuleTests extends BookManagementApplicationTests{

@Autowired
IBookRepository ibookRepo;

@Autowired
IBookService ibookSer;

@Test
void getBooksByTitle() {
	Book b=new Book(7,"Maths","Ramanujan","Mathematics","aaaa",450.00,LocalDate.now(),
		LocalDate.now(),new Category());
	ibookRepo.save(b);
	List<Book> book1=ibookRepo.findByTitle("Maths");
	Optional<Book> book2=ibookRepo.findById(7);
	assertThat(book2.isPresent()).isEqualTo(!book1.isEmpty());		
}	
@Test
void getAllBooks() {
	int count=ibookRepo.bookCount();
	List<Book> list=ibookRepo.findAll();
	 assertEquals(count,list.size());	
}
@Test
void createBook() {
	Book b=new Book(6,"wingsOfFire","Abdul Kalam","Life Story","vvv",450.00,LocalDate.now(),
		LocalDate.now(),new Category());
	List<Book> book1=ibookRepo.findAll();
	ibookRepo.save(b);
	List<Book> book2=ibookRepo.findAll();
	assertThat(book1.size()+1).isEqualTo(book2.size());		
}
@Test
void delete() {
	List<Book> book1=ibookRepo.findAll();
	List<Book> book2=ibookSer.deleteBook(5);
	 assertThat(book1.size()-1).isEqualTo(book2.size());
}
@Test
void update() {
	Optional<Book> b=ibookRepo.findById(1);
	Book book=ibookSer.editBook(b.get(),1);
	assertThat(ibookRepo.count()).isEqualTo(ibookRepo.bookCount());
}
}