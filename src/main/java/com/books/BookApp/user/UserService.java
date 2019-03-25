package com.books.BookApp.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.BookApp.book.Book;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}


	public Optional<User> getUserById(int userId) {
		return userRepository.findById(userId);
	}

}
