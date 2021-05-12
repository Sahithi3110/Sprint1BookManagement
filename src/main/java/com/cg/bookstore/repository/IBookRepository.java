package com.cg.bookstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer>{

	@Query(value="select b from Book b where b.title=:title")
	public List<Book> findByTitle(String title);
	
	@Query(value="select * from book where category_category_id=:categoryId",nativeQuery=true)
	public List<Book> findByCategory(@Param("categoryId") Integer categoryId);
	
	@Query(value="select b from Book b where b.description like %:keyword%")
	public List<Book> search(@Param("keyword") String keyword);
	
	@Query(value="select * from Book order by book_id desc limit 1 ",nativeQuery=true)
	public List<Book> listRecentlyAdded();
	
	@Query(value="select count(book_id) from book",nativeQuery=true)
	public int bookCount();
	
	
    
	
}
