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
	 * 1. ����һ�������б���η���һ����ÿ�����ֵ�ƽ�����ɵ��б��أ�
	 * �������[1,2,3,4,5], Ӧ�÷���[1,4,9,16,25]
	 */
	@Test
	public void test1() {
		Integer[] numIntegers = new Integer[] {1,2,3,4,5};
		Arrays.stream(numIntegers)
			.map(x->x*x)
			.forEach(System.out::println);
	}
	
	final List<Employee> listEmployee = Arrays.asList(
		new Employee("����", 35, new BigDecimal(29000), STATUS.FREE),
		new Employee("����", 32, new BigDecimal(12000), STATUS.BUSY),
		new Employee("���", 32, new BigDecimal(17000), STATUS.VOCATION),
		new Employee("������", 25, new BigDecimal(4800), STATUS.FREE),
		new Employee("����", 22, new BigDecimal(4000), STATUS.BUSY)
	);
	
	/**
	 * ��ô��map��reduce������һ�������ж��ٸ�employee
	 */
	@Test
	public  void test2() {
		Optional<Integer> optional = listEmployee.stream()
			.map(e->1)
			.reduce(Integer::sum);
		
		System.out.println("how many="+optional.get());
			
	}
	
	
	
}
