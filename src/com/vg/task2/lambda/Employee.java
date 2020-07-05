package com.vg.task2.lambda;

import java.math.BigDecimal;

public class Employee {

	private String name;
	
	private int age;
	
	private BigDecimal salary;
	
	private STATUS status;
	
	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public enum STATUS{
		FREE,
		BUSY,
		VOCATION
	}
	
	public Employee() {
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Employee(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public Employee(String name, int age, BigDecimal salary, STATUS status) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", status=" + status + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
