package com.books.BookApp.book;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Book {
	
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String iSBN;
	
	private String title;
	private String author;
	private Integer publicationYear;
	private String publisher;
	private String smallImageURL;
	private String mediumImageURL;
	private String largeImageURL;
	
	
	public Book(String iSBN, String title, String author, Integer publicationYear, String publisher, String smallImageURL, String mediumImageURL, String largeImageURL) {
		this.iSBN = iSBN;
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
	
	public String getiSBN() {
		return iSBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
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
