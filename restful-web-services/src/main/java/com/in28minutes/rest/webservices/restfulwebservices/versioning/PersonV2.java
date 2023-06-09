package com.in28minutes.rest.webservices.restfulwebservices.versioning;

public class PersonV2 extends Name {
	private Name name;

	public PersonV2(Name name) {
		super(name.getFirstName(), name.getLastName());
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

	public Name getName() {
		return name;
	}

}
