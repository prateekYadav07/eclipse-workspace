package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Chicken implements InitializingBean, DisposableBean{
	public double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Chicken() {
		super();
	}

	@Override
	public String toString() {
		return "Chicken [price=" + price + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// after properties means init method
		System.out.println("eating chicken");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("bones left");
	}
	
	

}
