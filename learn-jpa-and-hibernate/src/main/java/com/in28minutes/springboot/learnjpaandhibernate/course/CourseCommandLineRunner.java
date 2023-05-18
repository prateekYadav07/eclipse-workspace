package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository courseJdbcRepository;
	
	@Autowired
	private CourseJpaRepository courseJpaRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJpaRepository.insert(new Course(1, "Learn Spring", "in28minutes"));
		courseJpaRepository.insert(new Course(2, "Learn AWS", "in28minutes"));
		courseJpaRepository.insert(new Course(3, "Learn React", "in28minutes"));
		courseJpaRepository.insert(new Course(4, "Learn PostgressSQL", "in28minutes"));
		
		courseJpaRepository.deleteById(2);
		System.out.println(courseJpaRepository.findById(3));
	}

}
