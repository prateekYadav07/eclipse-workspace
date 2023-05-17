package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(1, "Learn Spring", "in28minutes"));
		courseJdbcRepository.insert(new Course(2, "Learn AWS", "in28minutes"));
		courseJdbcRepository.insert(new Course(3, "Learn React", "in28minutes"));
		courseJdbcRepository.insert(new Course(4, "Learn PostgressSQL", "in28minutes"));
		
		courseJdbcRepository.deleteById(2);
	}

}
