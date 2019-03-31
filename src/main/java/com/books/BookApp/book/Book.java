package com.books.BookApp.book;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.books.BookApp.rating.BookRating;




@Entity
public class Book implements Serializable {
	
	
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
	
	
	@OneToMany(mappedBy="book", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<BookRating> ratings = new HashSet<>();
	
	
	public Book(String iSBN, String title, String author, Integer publicationYear, String publisher, String smallImageURL, String mediumImageURL, String largeImageURL, BookRating ...ratings) {
		this.iSBN = iSBN;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.smallImageURL = smallImageURL;
		this.mediumImageURL = mediumImageURL;
		this.largeImageURL = largeImageURL;
	}
	
	

	public Set<BookRating> getRatings() {
		return ratings;
	}
	
	public void setRatings(Set<BookRating> ratings) {
		this.ratings = ratings;
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
