package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<User> retrieveAUserById(@PathVariable long id) {
		User userById = userDaoService.getUserById(id);
		if (userById == null)
			throw new UserNotFoundException("id: " + id);
		
		EntityModel<User> entityModel = EntityModel.of(userById);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User newUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("{id}")
	public void deleteUserById(@PathVariable long id) {
		userDaoService.deleteById(id);
	}

}
