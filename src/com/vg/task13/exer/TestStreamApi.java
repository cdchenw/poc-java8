package com.vg.task13.exer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.vg.task2.lambda.Employee;
import com.vg.task2.lambda.Employee.STATUS;

public class TestStreamApi {

	/**
	 * 1. 给定一个数字列表，如何返回一个由每个数字的平方构成的列表呢？
	 * 比如给定[1,2,3,4,5], 应该返回[1,4,9,16,25]
	 */
	@Test
	public void test1() {
		Integer[] numIntegers = new Integer[] {1,2,3,4,5};
		Arrays.stream(numIntegers)
			.map(x->x*x)
			.forEach(System.out::println);
	}
	
	final List<Employee> listEmployee = Arrays.asList(
		new Employee("王洪", 35, new BigDecimal(29000), STATUS.FREE),
		new Employee("赵武", 32, new BigDecimal(12000), STATUS.BUSY),
		new Employee("李白", 32, new BigDecimal(17000), STATUS.VOCATION),
		new Employee("刘明明", 25, new BigDecimal(4800), STATUS.FREE),
		new Employee("洪吴", 22, new BigDecimal(4000), STATUS.BUSY)
	);
	
	/**
	 * 怎么用map和reduce方法数一数流中有多少个employee
	 */
	@Test
	public  void test2() {
		Optional<Integer> optional = listEmployee.stream()
			.map(e->1)
			.reduce(Integer::sum);
		
		System.out.println("how many="+optional.get());
			
	}
	
	
	
}
