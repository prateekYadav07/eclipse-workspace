package com.springcore.ci;

import java.util.List;

public class Person {
	private String name;
	private int personId;
	private Certificate cert;
	private List<String> addrList;

	public Person(String name, int personId, Certificate cert, List<String> addrList) {
		this.name = name;
		this.personId = personId;
		this.cert = cert;
		this.addrList = addrList;
	}

	@Override
	public String toString() {
		return this.name + " " + this.personId + " {" + this.cert.getName() + "}" + "{" + this.addrList + "}";
	}
}
