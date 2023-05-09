package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address(String firstline, String city) {
}

record Person(String name, int age, Address address) {
}

@Configuration
public class HelloWorldConfig {

	@Bean
	public String name() {
		return "Prateek";
	}

	@Bean
	public int age() {
		return 15;
	}

	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Dalal Path", "Bombay"));
	}

	@Bean
	public Person person2MethodCall() {
		return new Person("Ravi", 20, address());
	}

	@Bean
	public Person person2ParamsCall(String name, int age, Address address3) {
		return new Person(name, age, address3);
	}

	@Bean
	public Person person3Qualifier(String name, int age, @Qualifier("addr4Qual") Address address3) {
		return new Person(name, age, address3);
	}

	@Bean
	public Address address() {
		return new Address("Kartavya path", "New Delhi");
	}

	@Bean(name = "address3")
	public Address address3() {
		return new Address("moti nagar", "New Delhi");
	}

	@Bean(name = "address4")
	@Qualifier("addr4Qual")
	@Primary
	public Address address4() {
		return new Address("raqab ganj", "Lucknow");
	}

}
