package com.vg.task15.optional;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;

import com.vg.task2.lambda.Employee;

public class TestOptional {

	/**
	 * Optional�ĳ��÷���
	 * 1) Optional.of(T t):	����һ��Optionalʵ�� 
	 *	2) Optional.empty():	����һ���յ�Optionalʵ��
	 *	3) Optional.ofNullable(T t): ��t��Ϊnull, ����Optionalʵ�������ߴ�����ʵ��
	 *	4) isPresent():	�ж��Ƿ�ֵ����
	 *	5)	orElse(T t):	��ε��ö������ֵ���򷵻�ֵ�����߷���t
	 * 6) orElseGet(Supplier? supp)����ε��ö������ֵ���򷵻�ֵ�����߷���s��ȡ��ֵ
	 * 7) map(Function f):	 �����ֵ��������д��������ش�����Optonal,���߷���Optiona.empty();
	 * *) flatMap(Function f): ��map���ƣ�Ҫ�󷵻�ֵ������Optional;
	 */
	@Test
	public void test1() {
		Optional<Employee> optional = Optional.of(new Employee("����", 13, new BigDecimal(100000)));
		System.out.println("test1, instance="+optional.get());
		
//		Optional<Employee> optional1 = Optional.of(null);
//		System.out.println("test1, instance="+optional1.get());
	}
	
	@Test
	public void test2() {
		Optional<Employee> optional = Optional.empty();
		System.out.println("test2, instance="+optional.get());
	}
	
	@Test
	public void test3() {
		Optional<Employee> optional = Optional.ofNullable(null);
		System.out.println("test3, instance="+optional.get());
	}
	
	@Test
	public void test4() {
//		Optional<Employee> optional = Optional.of(new Employee("����", 13, new BigDecimal(100000)));
//		if(optional.isPresent()) {
//			System.out.println("test4, instance="+optional.get());
//		}
		
		Optional<Employee> optional = Optional.ofNullable(null);
		Employee employee = optional.orElse(new Employee("����", 13, new BigDecimal(100000)));
		System.out.println("test4, instance="+employee);
	}
	
	@Test
	public void test5() {
		Optional<Employee> optional = Optional.ofNullable(null);
		Employee employee = optional.orElseGet(()->new Employee("����", 13, new BigDecimal(100000)));
		System.out.println("test5, instance="+employee);
	}
	
	@Test
	public void test6() {
		Optional<Employee> optional = Optional.ofNullable(new Employee("������", 13, new BigDecimal(100000)));
		Optional<String> empName = optional.map((e)->e.getName());
		System.out.println("test6, empName="+empName.get());
	}
	
	@Test
	public void test7() {
		Optional<Employee> optional = Optional.ofNullable(new Employee("������", 13, new BigDecimal(100000)));
		Optional<String> empName = optional.flatMap((e)->Optional.of(e.getName()));  //ע�������tes6����
		System.out.println("test7, empName="+empName.get());
	}
}
