package com.books.BookApp.rating;

import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.books.BookApp.book.Book;
import com.books.BookApp.user.User;

@RestController
public class BookRatingController {
	
	private BookRatingService bookRatingService;
	
	public BookRatingController(BookRatingService bookRatingService) {
		this.bookRatingService = bookRatingService;
	}
	
	@RequestMapping(value="/bookrating/add", method=RequestMethod.POST, consumes="application/json") 
	public BookRating addBookRating(@RequestBody BookRating rating) {
		rating.setUser(new User());
		rating.setBook(new Book());
		return bookRatingService.addRating(rating);
	}
	
	
	@RequestMapping(value="/bookratings", method=RequestMethod.GET)
	public List<BookRating> getBookRatings() {
		return bookRatingService.getBookRatings();
	}
	

}
