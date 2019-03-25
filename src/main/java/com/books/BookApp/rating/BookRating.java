package com.books.BookApp.rating;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.books.BookApp.book.Book;
import com.books.BookApp.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BookRating {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String ISBN;
	
	
	private int bookRating;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Book book;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	private User user;
	
	public BookRating(long id, String ISBN, int bookRating) {
		this.id = id;
		this.ISBN = ISBN;
		this.bookRating = bookRating;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public BookRating() {
		
	}
	
	public Book getBook() {
		return book;
	}
	
	
	public long getId() {
		return id;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
}
