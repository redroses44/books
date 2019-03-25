package com.books.BookApp.rating;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRatingRepository extends CrudRepository<BookRating, Integer> {
	
	@Override
	public List<BookRating> findAll();

	

}
