package com.cg.bookstore.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.exceptions.NoBookException;
import com.cg.bookstore.repository.IBookRepository;

@Service
public class BookService implements IBookService{

	@Autowired
	IBookRepository iBookRepo;
	public List<Book> findByTitle(String title) {
		return iBookRepo.findByTitle(title);
	}
	
	public Optional<Book> createBook(Book b)
	{
		iBookRepo.save(b);
		return Optional.of(b);
	}
	public List<Book> listAllBooks()
	{
		return iBookRepo.findAll();
	}
	public List<Book> deleteBook(int id) throws NoBookException
	{
		Optional<Book> book=iBookRepo.findById(id);
		if(book.isEmpty())
			throw new NoBookException("Entered ID is not found");
		else {
		iBookRepo.deleteById(id);
		return iBookRepo.findAll();	
		}
	}
	public Book editBook(Book b,Integer id) throws NoBookException{
		Optional<Book> book=iBookRepo.findById(id);
		if(book.isEmpty())
			throw new NoBookException("Entered ID is not found");
		else {
		iBookRepo.save(b);
		return b;
		}
	}
	public List<Book> listBooksByCategory(String cat){
		return iBookRepo.findAll();
	}
	
}
