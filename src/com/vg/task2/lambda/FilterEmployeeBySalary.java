package com.vg.task2.lambda;

import java.math.BigDecimal;

public class FilterEmployeeBySalary implements MyPredicate<Employee> {
	@Override
	public boolean verify(Employee employee){
		return employee.getSalary().compareTo(new BigDecimal(5000))>0;
	}
}
