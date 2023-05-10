package com.in28minutes.learnspringframework.game;

public class SuperContra implements GamingConsole {

	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("prone");
	}

	public void left() {
		System.out.println("back");
	}

	public void right() {
		System.out.println("shoot");
	}

	@Override
	public String toString() {
		return "SuperContra [getClass()=" + getClass();
	}

}
