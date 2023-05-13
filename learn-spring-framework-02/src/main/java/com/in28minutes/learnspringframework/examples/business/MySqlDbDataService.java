package com.in28minutes.learnspringframework.examples.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Qualifier("mysql")
public class MySqlDbDataService implements DataService {

	@Override
	public int[] retriveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}
