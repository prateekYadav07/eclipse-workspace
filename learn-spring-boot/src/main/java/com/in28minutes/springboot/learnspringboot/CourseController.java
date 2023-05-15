package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(new Course(1, "Learn Springboot", "in28minutes"),
				new Course(2, "Learn DSA", "in28minutes"),
				new Course(3, "Learn Azure", "in28minutes"),
				new Course(3, "Learn Python", "in28minutes")
				
				);
	}
	
	@RequestMapping("/")
	public String helloWorld() {
		return "Hello world";
	}

}
