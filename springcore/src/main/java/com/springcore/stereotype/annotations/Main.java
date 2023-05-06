package com.springcore.stereotype.annotations;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/stereotype/annotations/stereo.xml");
		PowerRangers powerRangers = context.getBean("powerRangers", PowerRangers.class);
		System.out.println(powerRangers);
		context.close();
	}
}
