package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.Pacman;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncher {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				GamingAppLauncher.class)) {
			context.getBean(GameRunner.class).run();
//			context.getBean(GameRunner.class).run();
		}
	}

}
