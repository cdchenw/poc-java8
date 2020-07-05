package com.vg.task4.lambdaexer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.vg.task2.lambda.Employee;

public class TestLambda {

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("王洪", 35, new BigDecimal(29000)),
			new Employee("李白", 32, new BigDecimal(17000)),
			new Employee("赵武", 31, new BigDecimal(12000)),
			new Employee("刘明明", 25, new BigDecimal(4800))
		);
	
	@Test
	public void test1() {
		Collections.sort(listEmployee,  (e1, e2) -> {
			if(e1.getAge() ==  e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for(Employee employee: listEmployee) {
			System.out.println("test1>>"+employee);
		}
	}
	
	@Test
	public void test2() {
		String resultString = strHandler(" I love this game! ", str->{
			return str.trim();
		});
		System.out.println("test2>>"+resultString);
	}
	
	public String strHandler(String str, MyFunction mf) {
		return mf.formatString(str);
	}
	
	//需求，对于两个long型数据进行处理
	public Long op(Long l1, Long l2, FunCalculator<Long, Long> fc) {
		return fc.getValue(l1, l2);
	}
	
	@Test
	public void test3(){
		long result = op(100L, 200L, (x,y)->{
			return x*y;
		});
		System.out.println("test3>>"+result);
	}
}
