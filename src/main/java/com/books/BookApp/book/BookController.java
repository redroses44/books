package com.books.BookApp.book;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/book/add", method=RequestMethod.POST, consumes="application/json")
	@CrossOrigin(origins = "*")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@GetMapping(value="/books")
	@CrossOrigin(origins = "*")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	@GetMapping(value="/books/{isbn}")
	@CrossOrigin(origins = "*")
	public Optional<Book> getBook(@PathVariable("isbn") String iSBN) {
		return bookService.getBookByISBN(iSBN);
	}
	
	@Transactional
	@DeleteMapping(value="/books/{isbn}")
	@CrossOrigin(origins="*")
	public Optional<Book> deleteBook(@PathVariable("isbn") String iSBN) {
		return bookService.deleteBookByISBN(iSBN);
	}
	
}
