package com.books.BookApp.rating;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BookRatingController {
	
	private BookRatingService bookRatingService;
	
	public BookRatingController(BookRatingService bookRatingService) {
		this.bookRatingService = bookRatingService;
	}
	
	@PostMapping(value="/bookrating/add") 
	@CrossOrigin(origins = "*")
	public BookRating addBookRating(@RequestBody BookRating rating) {
		
		return bookRatingService.addRating(rating);
	}
	
	
	@GetMapping(value="/bookratings")
	@CrossOrigin(origins = "*")
	public List<BookRating> getBookRatings() {
		return bookRatingService.getBookRatings();
	}
	

}
