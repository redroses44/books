package com.books.BookApp.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
	
	@Override
	public List<Book> findAll();
	
	


	public Book findByiSBN(String iSBN);

	public Optional<Book> deleteByiSBN(String iSBN);


}
