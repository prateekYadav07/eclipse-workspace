package com.in28minutes.learnspringframework.examples.a2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

// @lazy will prevent eager loading i.e. initialization won't happen right when context has been inititalized
// so lazy means the bean will be initialized right before use
@Component
@Lazy
class ClassB {

	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("intitalization logic");
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("done" + this.classA);
	}

}

@Configuration
@ComponentScan
public class LazyInitLauncherApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				LazyInitLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("context init");
			context.getBean(ClassB.class).doSomething();
		}
	}

}
