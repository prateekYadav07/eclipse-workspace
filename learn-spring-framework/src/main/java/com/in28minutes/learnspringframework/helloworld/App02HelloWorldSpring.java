package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		// 1. Launch a spring context
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				HelloWorldConfig.class)) {
			// 2. Configure the things that we want spring to manage - @Configuration class
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person2ParamsCall"));
			System.out.println(context.getBean("person3Qualifier"));
			System.out.println(context.getBean("address"));
			System.out.println(context.getBean(Address.class));
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
