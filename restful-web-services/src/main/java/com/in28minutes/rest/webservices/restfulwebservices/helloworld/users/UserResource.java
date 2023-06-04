package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService userDaoService;

	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@GetMapping("users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAllUsers();
	}

	@GetMapping("users/{id}")
	public User retrieveAUserById(@PathVariable long id) {
		return userDaoService.getUserById(id);
	}

}
