package com.books.BookApp.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	public Book getBookByISBN(String iSBN) {
		return bookRepository.findByiSBN(iSBN);
	}

	public Optional<Book> deleteBookByISBN(String iSBN) {
		return bookRepository.deleteByiSBN(iSBN);
		
	}

}
