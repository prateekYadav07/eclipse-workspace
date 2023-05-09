package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.Pacman;
import com.in28minutes.learnspringframework.game.SuperContra;

public class App01GamingBasic {

	public static void main(String[] args) {
		GamingConsole mario = new MarioGame();
		GamingConsole contra = new SuperContra();
		GamingConsole pacman = new Pacman();
		GameRunner gameRunner = new GameRunner(mario);
		GameRunner gameRunner2 = new GameRunner(contra);
		GameRunner gameRunner3 = new GameRunner(pacman);
		
		
		gameRunner.run();
		gameRunner2.run();
		gameRunner3.run();
	}

}
