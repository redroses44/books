package com.books.BookApp.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	
	public Optional<Book> getBookByISBN(String iSBN) {
		return bookRepository.findByiSBN(iSBN);
	}

	public Optional<Book> deleteBookByISBN(String iSBN) {
		return bookRepository.deleteByiSBN(iSBN);
		
	}
	
	public List<Book> findByRatings() {
		List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.ASC, "ratings.bookRating"));
		return books;
	}
	
	public List<Book> findByOrderByBookRatingDesc() {
		return bookRepository.findByOrderByRatingsDesc();
	}

}
