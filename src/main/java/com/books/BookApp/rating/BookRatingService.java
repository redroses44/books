package com.books.BookApp.rating;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.BookApp.book.Book;

@Service
public class BookRatingService {
	
	@Autowired
	private BookRatingRepository bookRatingRepo;
	

	
	public BookRatingService(BookRatingRepository bookRatingRepo) {
		this.bookRatingRepo = bookRatingRepo;
	}
	

	public BookRating addRating(BookRating rating) {
		return bookRatingRepo.save(rating);
	}

	public List<BookRating> getBookRatings() {
		return bookRatingRepo.findAll();
	}

}
