package com.books.BookApp.book;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.books.BookApp.rating.BookRating;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Book {
	
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ISBN;
	
	private String title;
	private String author;
	private Integer publicationYear;
	private String publisher;
	private String smallImageURL;
	private String mediumImageURL;
	private String largeImageURL;
	
	
	@OneToMany(mappedBy="book", cascade=CascadeType.ALL)
	@JsonIgnore

	private List<BookRating> ratings;
	
	public Book(Integer ISBN, String title, String author, Integer publicationYear, String publisher, String smallImageURL, String mediumImageURL, String largeImageURL) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.smallImageURL = smallImageURL;
		this.mediumImageURL = mediumImageURL;
		this.largeImageURL = largeImageURL;
	}
	
	public Book() {
		
	}
	
	public Integer getISBN() {
		return ISBN;
	}
	
	public void setRatings(List<BookRating> ratings) {
		this.ratings = ratings;
	}
	public List<BookRating> getRatings() {
		return ratings;
	}

	public String getTitle() {
		return title;
	}
	
	public void setISBN(Integer ISBN) {
		this.ISBN = ISBN;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getSmallImageURL() {
		return smallImageURL;
	}

	public String getMediumImageURL() {
		return mediumImageURL;
	}

	public String getLargeImageURL() {
		return largeImageURL;
	}
	
}
