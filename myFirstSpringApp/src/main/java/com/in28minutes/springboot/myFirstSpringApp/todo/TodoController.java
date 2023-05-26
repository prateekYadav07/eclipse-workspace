package com.in28minutes.springboot.myFirstSpringApp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// list-todos
	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		model.addAttribute("todos", this.todoService.findByUsername("in28minutes"));
		return "listTodos";
	}

	// add-todo
	@RequestMapping("add-todos")
	public String showNewTodoPage() {
		return "todo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String storeTodo(@RequestParam String description, ModelMap model) {
		todoService.addTodo((String) model.get("name"), description, LocalDate.now().plusWeeks(2), false);
		return "redirect:list-todos";
	}

}
