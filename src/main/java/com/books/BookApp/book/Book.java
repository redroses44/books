package com.books.BookApp.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
	
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String ISBN;
	
	private String title;
	private String author;
	private Integer publicationYear;
	private String publisher;
	private String smallImageURL;
	private String mediumImageURL;
	private String largeImageURL;
	
	public Book(String ISBN, String title, String author, Integer publicationYear, String publisher, String smallImageURL, String mediumImageURL, String largeImageURL) {
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

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
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
