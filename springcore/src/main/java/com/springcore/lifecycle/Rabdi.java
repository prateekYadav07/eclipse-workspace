package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Rabdi {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Rabdi [price=" + price + "]";
	}

	public Rabdi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void init() {
		System.out.println("rabdi ordered");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("rabdi done");
	}

}
