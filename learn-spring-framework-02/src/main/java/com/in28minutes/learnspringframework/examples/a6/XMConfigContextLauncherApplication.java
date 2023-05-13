package com.in28minutes.learnspringframework.examples.a6;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

@Configuration
@ComponentScan
public class XMConfigContextLauncherApplication {

	public static void main(String[] args) {

		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			context.getBean("pacmanGameRunner", GameRunner.class).run();
			context.getBean("marioGameRunner", GameRunner.class).run();
		}
	}

}
