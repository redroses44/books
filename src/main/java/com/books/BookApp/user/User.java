package com.books.BookApp.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "user_id", updatable = false, nullable = false)
	private int userId;
	
	
	
	private String location;
	private Integer age;
	
	public User(int userId, String location, Integer age) {
		this.userId = userId;
		this.location = location;
		this.age = age;

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
