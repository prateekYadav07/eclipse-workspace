package com.in28minutes.learnspringframework.examples.business;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysql")
public class MySqlDbDataService implements DataService {

	@Override
	public int[] retriveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}
