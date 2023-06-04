package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello world";
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello world");
	}

	@GetMapping(path = "hello-world/path-var/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Hello world %s", name));
	}

}
