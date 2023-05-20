package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository courseJdbcRepository;

//	@Autowired
//	private CourseJpaRepository courseJpaRepository;

	@Autowired
	private CourseSpringDataJPARepository courseSpringDataJPARepository;

	@Override
	public void run(String... args) throws Exception {
		courseSpringDataJPARepository.save(new Course(1, "Learn Spring", "in28minutes"));
		courseSpringDataJPARepository.save(new Course(2, "Learn AWS", "Jeff Bezos"));
		courseSpringDataJPARepository.save(new Course(3, "Learn React", "Zuck"));
		courseSpringDataJPARepository.save(new Course(4, "Learn PostgressSQL", "in28minutes"));
		courseSpringDataJPARepository.deleteById(2l);
		System.out.println(courseSpringDataJPARepository.findById(3l));

		System.out.println(courseSpringDataJPARepository.findAll());
		System.out.println(courseSpringDataJPARepository.findByAuthor("in28minutes"));
		System.out.println(courseSpringDataJPARepository.findByAuthor(""));
		System.out.println(courseSpringDataJPARepository.findByName("Learn React"));
	}

}
