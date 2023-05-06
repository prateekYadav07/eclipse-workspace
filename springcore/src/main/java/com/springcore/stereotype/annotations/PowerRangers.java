package com.springcore.stereotype.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PowerRangers {

	@Value("Karl")
	public String name;
	
	@Value("Red")
	public String color;

	@Override
	public String toString() {
		return "PowerRangers [name=" + name + ", color=" + color + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
