package com.in28minutes.springboot.myFirstSpringApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;

	static {
		todos.add(new Todo(todosCount++, "in28minutes", "Learn Spring", LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(todosCount++, "in28minutes", "Learn AWS", LocalDate.now().plusWeeks(1), false));
		todos.add(new Todo(todosCount++, "in28minutes", "Learn PostgressSQL", LocalDate.now().plusYears(1), false));
	}

	public List<Todo> findByUsername(String username) {
		List<Todo> filteredList = todos.stream().filter(item -> item.getUsername().equalsIgnoreCase(username)).toList();
		if (!filteredList.isEmpty()) {
			return filteredList;
		}
		return null;
	}
	
	public void addTodo(String username, String description, LocalDate date, boolean done) {
		todos.add(new Todo(todosCount++, username, description, date, done));
	}

}
