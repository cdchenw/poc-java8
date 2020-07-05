package com.vg.task8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.vg.task2.lambda.Employee;

/**
 * 1.stream��������������
 * 
 * 1�� ����stream
 * 
 * 2���м����
 * 
 * 3�� ��ֹ����
 *
 */
public class TestStreamApi {

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("����", 35, new BigDecimal(29000)),
			new Employee("���", 32, new BigDecimal(17000)),
			new Employee("����", 31, new BigDecimal(12000)),
			new Employee("������", 25, new BigDecimal(4800)),
			new Employee("����", 22, new BigDecimal(4000))
		);
	
	//�м����
	
	/**
	 * 1. ɸѡ����Ƭ
	 * filter������lambda, �������ų�ĳЩԪ��
	 * limit���ض�������ȡָ��������Ԫ��
	 * skip(n)������Ԫ�أ�����һ���ӵ���ǰ��N��Ԫ�ص���,������N�����򷵻�һ���յ���
	 * distinct�� ɸѡ��ͨ������Ԫ�ص�hashCode()��equals() ȥ���ظ����
	 * 
	 */
	
	@Test
	public void test1() {
		System.out.println("test1 start...");
		listEmployee.stream()
			.filter((e)->e.getAge()>30) //�м����
			.forEach(System.out::println); //��ֹ������һ����ִ��ȫ�����ݣ���"������ֵ"
	}
	
	//�ⲿ����
//	@Test
//	public void test2() {
//		Iterable<Employee> it = listEmployee.iterator();
//		while (it.hasMoreElements()) {
//			Employee emp = (Employee) it.nextElement();
//			
//		}
//	}
	
	@Test
	public void test3() {
		System.out.println("test3 start...");
		listEmployee.stream()
			.filter( (x) -> {
				System.out.println("test3 ��·");
				return x.getSalary().compareTo(new BigDecimal(5000))>0;
			}).limit(2)
			.forEach(System.out::println);
	}
	
	@Test
	public void test4() {
		System.out.println("test4 start...");
		listEmployee.stream()
		.filter( (x) -> {
			System.out.println("test4 ��·");
			return x.getSalary().compareTo(new BigDecimal(5000))>0;
		}).skip(2)
		.distinct()
		.forEach(System.out::println);
	}
}
