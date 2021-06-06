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
import com.cg.bookstore.serviceImplementation.IBookService;

@SpringBootTest
public class BookModuleTests extends BookManagementApplicationTests{

@Autowired
IBookRepository ibookRepo;

@Autowired
IBookService ibookSer;

@Test
void getBooksByTitle() {
	List<Book> book1=ibookRepo.findByTitle("Maths");
	Optional<Book> book2=ibookRepo.findById(7);
	assertThat(!book1.isEmpty()).isEqualTo(book2.isPresent());		
}	
@Test
void getAllBooks() {
	int count=ibookRepo.bookCount();
	List<Book> list=ibookRepo.findAll();
	 assertEquals(count,list.size());	
}

@Test
void delete() {
	List<Book> book1=ibookRepo.findAll();
	List<Book> book2=ibookSer.deleteBook(4);
	 assertThat(book1.size()-1).isEqualTo(book2.size());
}
@Test
void update() {
//	Optional<Book> b=ibookRepo.findById(3);
//	Book book=ibookSer.editBook(b.get(),3);
//	assertThat(ibookRepo.count()).isEqualTo(ibookRepo.bookCount());
	Book book = ibookRepo.findById(3).get();
	book.setAuthor("SahithiReddy");
	ibookSer.editBook(book, 3);

	Book afterUpdation = ibookRepo.findById(3).get();
	assertThat(afterUpdation.getAuthor()).isEqualTo("SahithiReddy");

}
}