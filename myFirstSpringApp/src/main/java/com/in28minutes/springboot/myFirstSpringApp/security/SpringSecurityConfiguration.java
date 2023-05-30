package com.in28minutes.springboot.myFirstSpringApp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Value("${security.enable.csrf}")
	public boolean csrfEnabled;

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

	// All endpoints are protected
	// A login form is shown for unauthorized requests
	// need to disable CSRF

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
		try {
			httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
			httpSecurity.formLogin(Customizer.withDefaults());
			if (csrfEnabled)
				httpSecurity.csrf().disable();
			httpSecurity.headers().frameOptions().disable();
			return httpSecurity.build();
		} catch (Exception e) {
			return null;
		}
	}

}
