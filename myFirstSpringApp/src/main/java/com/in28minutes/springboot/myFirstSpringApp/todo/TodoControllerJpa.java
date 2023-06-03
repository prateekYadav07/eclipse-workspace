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

	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	// list-todos
	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		model.addAttribute("todos", todoRepository.findByUsername((String) model.get("name")));
		return "listTodos";
	}

	// add-todo
	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, (String) model.get("name"), "", LocalDate.now(), false));
		model.addAttribute("done", false);
		return "todo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String storeTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUsername((String) model.get("name"));
		todoRepository.save(todo);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo")
	public String deleteATodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		model.addAttribute("showDone", true);
		model.addAttribute("isDone", todo.isDone());
		return "todo";
	}

	@RequestMapping(value = "edit-todo", method = RequestMethod.POST)
	public String updateATodo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors())
			return "todo";
		todo.setUsername((String) model.get("name"));
		todoRepository.save(todo);
		return "redirect:list-todos";
	}

}
