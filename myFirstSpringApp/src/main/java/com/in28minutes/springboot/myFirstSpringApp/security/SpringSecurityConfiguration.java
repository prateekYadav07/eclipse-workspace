package com.in28minutes.springboot.myFirstSpringApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createUser("in28minutes", "dummy");
		UserDetails userDetails2 = createUser("prateek", "dummy");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createUser(String username, String password) {
		UserDetails userDetails = User.builder().passwordEncoder(input -> passwordEncoder().encode(input))
				.username(username).password(password).roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
