package com.springcore.standalone.collections;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

	private List<String> friends;
	private Map<String, String> courseInfo;
	private Properties props;

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public Map<String, String> getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(Map<String, String> courseInfo) {
		this.courseInfo = courseInfo;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "Person [friends=" + friends + ", courseInfo=" + courseInfo + ", props=" + props + "]";
	}

}
