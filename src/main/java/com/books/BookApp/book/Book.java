package com.books.BookApp.book;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.books.BookApp.rating.BookRating;



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
	
	
	@OneToMany(mappedBy="book")
	List<BookRating> ratings = new ArrayList<BookRating>();
	
	
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
	
	public void setRatings(BookRating rating) {
		if(rating.getISBN() == this.getiSBN()) {
			ratings.add(rating);
		}
	}
	
	public List<BookRating> getRatings() {
		return ratings;
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
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}
	
}
