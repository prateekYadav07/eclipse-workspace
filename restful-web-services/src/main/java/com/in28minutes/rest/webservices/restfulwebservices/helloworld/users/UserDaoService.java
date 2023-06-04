package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Joey", LocalDate.now()));
		users.add(new User(2, "Chandler", LocalDate.now()));
		users.add(new User(3, "Ross", LocalDate.now()));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User getUserById(long id) {
		List<User> usersList = users.stream().filter(item -> item.getId().equals(id)).toList();
		if (!usersList.isEmpty())
			return usersList.get(0);
		return null;
	}

}
