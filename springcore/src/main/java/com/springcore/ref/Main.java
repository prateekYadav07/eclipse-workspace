package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ref/refConfig.xml");
		A aobj = (A) context.getBean("aref");
		System.out.println(aobj.getX());
		System.out.println(aobj.getB());
		System.out.println(aobj.getB().getY());
		System.out.println(aobj);
	}
}
