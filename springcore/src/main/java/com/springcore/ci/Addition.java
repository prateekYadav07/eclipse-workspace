package com.springcore.ci;

public class Addition {
	private int a;
	private int b;

	public Addition(double a, double b) {
		this.a = (int) a;
		this.b = (int) b;
		System.out.println("Double parametrized constructor");
	}

	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Integer parametrized constructor");
	}
	
//	public Addition(int a, String b) {
//		super();
//		this.a = a;
//		this.b = Integer.parseInt(b);
//		System.out.println("String Integer parametrized constructor");
//	}

	public Addition(String a, String b) {
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
		System.out.println("String parametrized constructor");
	}

	public void doSum() {
		System.out.println("Sum is: " + (this.a + this.b));
	}

	@Override
	public String toString() {
		return this.a + " " + this.b;
	}

}
