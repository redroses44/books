package com.books.BookApp.rating;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.BookApp.book.Book;
import com.books.BookApp.book.BookRepository;

@Service
public class BookRatingService {
	
	@Autowired
	private BookRatingRepository bookRatingRepo;
	
	
	@Autowired
	private BookRepository bookRepo;

	
	public BookRatingService(BookRatingRepository bookRatingRepo) {
		this.bookRatingRepo = bookRatingRepo;
	}
	

	public BookRating addRating(String iSBN, BookRating rating) throws Exception {
		Set<BookRating> ratings = new HashSet<>();
		Book book1 = new Book();
		
		Optional<Book> byId = bookRepo.findByiSBN(iSBN);
		if(!byId.isPresent()) {
			throw new Exception("Book with isbn " + iSBN + " does not exist.");
		}
		Book book = byId.get();
		
		rating.setBook(book);
		
		BookRating rating1 = bookRatingRepo.save(rating);
		ratings.add(rating1);
		
		book1.setRatings(ratings);
		
		return rating1;
	}

	public List<BookRating> getBookRatings() {
		return bookRatingRepo.findAll();
	}

}
