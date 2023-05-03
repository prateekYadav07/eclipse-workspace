package com.springcore.auto.wire;

public class Employee {
	private Address addr;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address getAddr() {
		return addr;
	}

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
