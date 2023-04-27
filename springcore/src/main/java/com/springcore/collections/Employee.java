package com.springcore.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Employee {
	private String empName;
	private List<String> empPhones;
	private Set<String> empAddr;
	private Map<String, String> empCourses;
	private Properties props;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, List<String> empPhones, Set<String> empAddr, Map<String, String> empCourses) {
		super();
		this.empName = empName;
		this.empPhones = empPhones;
		this.empAddr = empAddr;
		this.empCourses = empCourses;
	}

	public List<String> getEmpPhones() {
		return empPhones;
	}

	public void setEmpPhones(List<String> empPhones) {
		this.empPhones = empPhones;
	}

	public Set<String> getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(Set<String> empAddr) {
		this.empAddr = empAddr;
	}

	public Map<String, String> getEmpCourses() {
		return empCourses;
	}

	public void setEmpCourses(Map<String, String> empCourses) {
		this.empCourses = empCourses;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empPhones=" + empPhones + ", empAddr=" + empAddr + ", empCourses="
				+ empCourses + ", props=" + props + "]";
	}

}
