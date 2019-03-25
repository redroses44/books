package com.books.BookApp.user;

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
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String location;
	private Integer age;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore

	private List<BookRating> ratings;
	

	public User(int userId, String location, Integer age) {
		this.userId = userId;
		this.location = location;
		this.age = age;

	}
	
	public List<BookRating> getRatings() {
		return ratings;
	}
	
	public void setRating(List<BookRating> ratings) {
		this.ratings = ratings;
	}
	
	public User() {
		
	}

	public int getUserId() {
		return userId;
	}

	public String getLocation() {
		return location;
	}

	public Integer getAge() {
		return age;
	}
}
