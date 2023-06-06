package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static long count = 0;

	static {
		users.add(new User(count++, "Joey", LocalDate.now()));
		users.add(new User(count++, "Chandler", LocalDate.now()));
		users.add(new User(count++, "Ross", LocalDate.now()));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User save(User user) {
		user.setId(count++);
		users.add(user);
		return user;
	}

	public User getUserById(long id) {
		return users.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
	}

	public void deleteById(long id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
