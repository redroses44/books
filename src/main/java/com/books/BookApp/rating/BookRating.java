package com.books.BookApp.rating;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.books.BookApp.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity	@IdClass(ProjectId.class)
public class BookRating implements Serializable {
	
	@Id
	private long userId;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String ISBN;
	
	private int bookRating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_isbn")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Book book;
	
	
	public BookRating(long userId, String ISBN, int bookRating) {
		this.userId = userId;
		this.ISBN = ISBN;
		this.bookRating = bookRating;
	}
	
	
	@JsonIgnore
	public void setBook(Book book) {
		this.book = book;
	}
	
	@JsonIgnore
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
