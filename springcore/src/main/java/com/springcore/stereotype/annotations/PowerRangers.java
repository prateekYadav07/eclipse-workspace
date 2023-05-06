package com.springcore.stereotype.annotations;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PowerRangers {

	@Value("Karl")
	public String name;

	@Value("Red")
	public String color;

	@Value("#{weapon}")
	public List<String> weapons;

	@Override
	public String toString() {
		return "PowerRangers [name=" + name + ", color=" + color + ", weapons=" + weapons + "]";
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

	public List<String> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<String> weapons) {
		this.weapons = weapons;
	}
}
