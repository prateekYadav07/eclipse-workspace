package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.Pacman;
import com.in28minutes.learnspringframework.game.SuperContra;

@Configuration
public class AppGameConfig {

	@Bean
	@Qualifier("mario")
	public GamingConsole mario() {
		GamingConsole console = new MarioGame();
		return console;
	}

	@Bean
	@Qualifier("contra")
	public GamingConsole superContra() {
		return new SuperContra();
	}

	@Bean
	@Qualifier("pacman")
	public GamingConsole pacman() {
		return new Pacman();
	}

	@Bean
	public GameRunner marioConsole(@Qualifier("mario") GamingConsole game) {
		return new GameRunner(game);
	}

	@Bean
	public GameRunner contraConsole(@Qualifier("contra") GamingConsole game) {
		return new GameRunner(game);
	}

	@Bean
	public GameRunner pacmanConsole(@Qualifier("pacman") GamingConsole game) {
		return new GameRunner(game);
	}

}
