package com.springcore.stereotype.annotations;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/stereotype/annotations/stereo.xml");
		PowerRangers powerRangers = context.getBean("powerRangers", PowerRangers.class);
		System.out.println(powerRangers);
		System.out.println(powerRangers.hashCode());
		
		PowerRangers powerRangers2 = context.getBean("powerRangers", PowerRangers.class);
		System.out.println(powerRangers2);
		System.out.println(powerRangers2.hashCode());
		context.close();
	}
}
