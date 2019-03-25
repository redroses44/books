package com.books.BookApp.book;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@GetMapping(value="/books")
	@CrossOrigin(origins = "*")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	
	
}
