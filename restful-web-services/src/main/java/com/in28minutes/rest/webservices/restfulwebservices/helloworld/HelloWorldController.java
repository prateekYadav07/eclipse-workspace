package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello world";
	}

	@GetMapping(path = "hello-world-i18n")
	public String helloWorldi18n() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
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
