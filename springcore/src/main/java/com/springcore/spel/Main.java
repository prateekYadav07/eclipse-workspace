package com.springcore.spel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/spel/spelConfig.xml");
		Demo d = context.getBean("demo", Demo.class);
		System.out.println(d);
		
		context.close();
	}
}
