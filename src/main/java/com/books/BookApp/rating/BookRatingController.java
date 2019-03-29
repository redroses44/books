package com.books.BookApp.rating;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins = "*")
	public BookRating addBookRating(@RequestBody BookRating rating) {
		return bookRatingService.addRating(rating);
	}
	
	
	@RequestMapping(value="/bookratings", method=RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<BookRating> getBookRatings() {
		return bookRatingService.getBookRatings();
	}
	

}
