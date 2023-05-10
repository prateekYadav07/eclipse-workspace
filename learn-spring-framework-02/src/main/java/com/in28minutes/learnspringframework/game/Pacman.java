package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pacmanConsole")
public class Pacman implements GamingConsole {

	public void up() {
		System.out.println("up");
	}

	public void down() {
		System.out.println("down");
	}

	public void left() {
		System.out.println("back");
	}

	public void right() {
		System.out.println("forward");
	}

	@Override
	public String toString() {
		return "Pacman [getClass()=" + getClass();
	}

}
