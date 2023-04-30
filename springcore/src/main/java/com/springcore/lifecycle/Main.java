package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/lcconfig.xml");
//		Samosa s1 = (Samosa) context.getBean("s1");
//		System.out.println(s1);
//		Chicken c1 = (Chicken) context.getBean("c1");
//		System.out.println(c1.toString());
		
		Rabdi r1 = (Rabdi) context.getBean("r1");
		System.out.println(r1);
		// registering shutdown hook is present in AbstractApplicationContext not in ApplicationContext
		context.registerShutdownHook();
	}
}
