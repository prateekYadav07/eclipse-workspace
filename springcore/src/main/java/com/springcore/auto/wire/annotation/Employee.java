package com.springcore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {

	// property autowired
	@Autowired
	@Qualifier("addr2") // cannot be used with constructor injection
	private Address addr;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address getAddr() {
		return addr;
	}

	// constructor autowired
	public Employee(Address addr) {
		super();
		System.out.println("inside constructor");
		this.addr = addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee [addr=" + addr + "]";
	}

}
