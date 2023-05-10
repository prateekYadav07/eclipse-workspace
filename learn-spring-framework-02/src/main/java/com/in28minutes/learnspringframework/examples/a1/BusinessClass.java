package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessClass {

	// autowired on fields means field injection
//	@Autowired
	DependencyOne dependencyOne;

//	@Autowired
	DependencyTwo dependencyTwo;

	public DependencyOne getDependencyOne() {
		return dependencyOne;
	}

	// autowired on setter method means setter injection
//	@Autowired
	public void setDependencyOne(DependencyOne dependencyOne) {
		System.out.println("setter injection " + dependencyOne);
		this.dependencyOne = dependencyOne;
	}

	// IN case of constructor we don't even need autowired annotation
//	@Autowired
	public BusinessClass(DependencyOne dependencyOne, DependencyTwo dependencyTwo) {
		super();
		System.out.println("constructor injection " + dependencyOne + " " + dependencyTwo);
		this.dependencyOne = dependencyOne;
		this.dependencyTwo = dependencyTwo;
	}

	public DependencyTwo getDependencyTwo() {
		return dependencyTwo;
	}

//	@Autowired
	public void setDependencyTwo(DependencyTwo dependencyTwo) {
		System.out.println("setter injection " + dependencyTwo);
		this.dependencyTwo = dependencyTwo;
	}

	@Override
	public String toString() {
		return "BusinessClass [dependencyOne=" + dependencyOne + ", dependencyTwo=" + dependencyTwo + "]";
	}

}
