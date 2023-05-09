package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

public class App01GamingBasic {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppGameConfig.class)) {
			context.getBean("marioConsole", GameRunner.class).run();
			context.getBean("contraConsole", GameRunner.class).run();
			context.getBean("pacmanConsole", GameRunner.class).run();
		}

//		GamingConsole mario = new MarioGame();
//		GamingConsole contra = new SuperContra();
//		GamingConsole pacman = new Pacman();
//		GameRunner gameRunner = new GameRunner(mario);
//		GameRunner gameRunner2 = new GameRunner(contra);
//		GameRunner gameRunner3 = new GameRunner(pacman);
//		
//		
//		gameRunner.run();
//		gameRunner2.run();
//		gameRunner3.run();
	}

}
