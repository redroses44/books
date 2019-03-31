package com.books.BookApp.rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.books.BookApp.book.Book;

@Entity	@IdClass(ProjectId.class)
public class BookRating {
	
	@Id
	private long userId;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String ISBN;
	
	private int bookRating;
	
	@ManyToOne()
	private Book book;
	
	
	public BookRating(long userId, String ISBN, int bookRating) {
		this.userId = userId;
		this.ISBN = ISBN;
		this.bookRating = bookRating;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}
	
	
	public BookRating() {
		
	}
	
	
	public long getId() {
		return userId;
	}
	
	public void setId(long userId) {
		this.userId = userId;
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
