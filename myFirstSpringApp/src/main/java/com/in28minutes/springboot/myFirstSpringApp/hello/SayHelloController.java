package com.in28minutes.springboot.myFirstSpringApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController{
	
	@RequestMapping("say-hello")
	public String sayHello() {
		return "huh!? What is this? a hello world url?";
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
