package com.in28minutes.springboot.myFirstSpringApp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoService todoService;
	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}

	// list-todos
	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		model.addAttribute("todos", todoRepository.findByUsername((String) model.get("name")));
		return "listTodos";
	}

	// add-todo
	@RequestMapping("add-todos")
	public String showNewTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, (String) model.get("name"), "", LocalDate.now(), false));
		return "todo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String storeTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo((String) model.get("name"), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteATodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		model.addAttribute("todo", todoService.findById(id));
		return "todo";
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.POST)
	public String updateATodo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";
		todo.setUsername((String) model.get("name"));
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

}
