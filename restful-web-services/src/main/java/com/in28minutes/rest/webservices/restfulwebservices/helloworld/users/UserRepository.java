package com.in28minutes.rest.webservices.restfulwebservices.helloworld.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	
}
