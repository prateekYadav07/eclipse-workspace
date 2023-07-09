package com.in28minutes.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		try {
//			// 1 All requests should be authenticated
//			httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//
//			// 2 If a request is not authenticated a webpage is shown, but for apis basic
//			// http auth must be in place
//			httpSecurity.httpBasic(withDefaults());
//			
//			// 3 disable csrf
//			httpSecurity.csrf(csrf -> csrf.disable());

			// above way is noob way of doing things

			return httpSecurity.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).httpBasic(withDefaults()).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
