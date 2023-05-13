package com.in28minutes.learnspringframework.examples.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {

	private DataService dataService;

	public BusinessCalculationService(@Qualifier("mysql")DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int max() {
		return Arrays.stream(dataService.retriveData()).max().orElse(0);
	}

}
