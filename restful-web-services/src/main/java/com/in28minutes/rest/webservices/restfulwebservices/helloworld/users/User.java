package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Size(min = 2, message = "Name should be atleast 2 characters long")
	@JsonProperty("user_name")
	private String name;
	@Past(message = "Birth date should be in the past")
	@DateTimeFormat(fallbackPatterns = {"yyyy-MM-dd"})
	@JsonProperty("birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
