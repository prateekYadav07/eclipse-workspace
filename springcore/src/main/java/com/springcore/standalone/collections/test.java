package com.springcore.standalone.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/standalone/collections/standalone.xml");
		Person p = context.getBean("p1", Person.class);
		System.out.println(p);
		System.out.println(p.getFriends().getClass().getName());
		System.out.println(p.getCourseInfo().getClass());
		System.out.println(p.getProps().getClass());
		System.out.println("+++++++++++++++++++++++++++++++++++");
		Person p2 = context.getBean("p2", Person.class);
		System.out.println(p2);
	}
}
