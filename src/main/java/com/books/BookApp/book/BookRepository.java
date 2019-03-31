package com.books.BookApp.book;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.BookApp.rating.BookRating;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Override
	public List<Book> findAll();
	
	

	public Optional<Book> findByiSBN(String iSBN);

	public Optional<Book> deleteByiSBN(String iSBN);
	
    List<Book> findByRatings(Set<BookRating> ratings, Sort sort);
	
	List<Book> findByOrderByRatingsDesc();

}
