package com.springcore.lifecycle;

public class Samosa {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("setting price");
		this.price = price;
	}

	public Samosa() {
		super();
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	
	private void init() {
		System.out.println("inside init method");
	}
	
	private void destroy() {
		System.out.println("Inside destroy method");
	}
}
