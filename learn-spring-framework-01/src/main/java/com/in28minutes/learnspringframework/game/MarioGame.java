package com.in28minutes.learnspringframework.game;

public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("duck");
	}

	public void left() {
		System.out.println("fallback");
	}

	public void right() {
		System.out.println("march");
	}

	@Override
	public String toString() {
		return "MarioGame [getClass()=" + getClass();
	}

}
