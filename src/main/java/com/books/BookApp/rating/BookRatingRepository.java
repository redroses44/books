package com.books.BookApp.rating;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Integer> {
	
	@Override
	public List<BookRating> findAll();

	

}
