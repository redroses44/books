package com.books.BookApp.user;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST,
			consumes="application/json")
	@CrossOrigin(origins = "*")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public Optional<User> getUser(@PathVariable("id") int userId) {
		return userService.getUserById(userId);
	}

}
