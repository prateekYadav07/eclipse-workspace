package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa/users")
public class UserResourceJPA {

	private UserRepository userRepository;
	private PostRepository postRepository;

	public UserResourceJPA(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@GetMapping("")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("{id}")
	public EntityModel<User> retrieveAUserById(@PathVariable long id) {
		Optional<User> userById = userRepository.findById(id);
		if (userById.isEmpty())
			throw new UserNotFoundException("id: " + id);

		EntityModel<User> entityModel = EntityModel.of(userById.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User newUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PostMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @Valid @RequestBody User user) {
		Optional<User> userToBeUpdated = userRepository.findById(id);
		userToBeUpdated.get().setName(user.getName());
		userToBeUpdated.get().setBirthDate(user.getBirthDate());
		userRepository.save(userToBeUpdated.get());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userToBeUpdated.get().getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("{id}")
	public void deleteUserById(@PathVariable long id) {
		userRepository.deleteById(id);
	}

	/**
	 * POST APIs
	 * 
	 * @return
	 */

	@GetMapping("{id}/posts")
	public List<Post> getAllPostsOfAUser(@PathVariable long id) {
		Optional<User> user = userRepository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id: " + id);

		return user.get().getPosts();
	}

	@GetMapping("{userId}/posts/{postId}")
	public EntityModel<Post> getAPost(@PathVariable long userId, @PathVariable long postId) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isEmpty())
			throw new UserNotFoundException("id: " + userId);
		Optional<Post> postById = postRepository.findById(postId);

		EntityModel<Post> entityModel = EntityModel.of(postById.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllPostsOfAUser(userId));
		entityModel.add(link.withRel("all-posts"));
		return entityModel;
	}

	@PostMapping("{id}/posts")
	public ResponseEntity<Object> getAllPostsOfAUser(@PathVariable long id, @Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id: " + id);
		post.setUser(user.get());
		Post postCreated = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(postCreated.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
