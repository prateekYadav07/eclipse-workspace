package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY = """
			insert into course (id, name, author)
			values (?, ?, ?);
			""";
	private static String DELETE_A_COURSE = """
			delete from course
			where id=?
			""";

	private static String SELECT_A_COURSE = """
			select * from course
			where id=?
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_A_COURSE, id);
	}

	public Course findById(long id) {
		// mapping resultSet -> Bean => Row Mapper
		return springJdbcTemplate.queryForObject(SELECT_A_COURSE, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
