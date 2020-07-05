package com.vg.task2.lambda;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

	@Override
	public boolean verify(Employee employee){
		return employee.getAge()>=35;
	}

}
