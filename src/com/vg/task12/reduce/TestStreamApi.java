package com.vg.task12.reduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.vg.task2.lambda.Employee;
import com.vg.task2.lambda.Employee.STATUS;

/**
 * 3�� ��ֹ����
 *
 */
public class TestStreamApi {

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("����", 35, new BigDecimal(29000), STATUS.FREE),
			new Employee("����", 32, new BigDecimal(12000), STATUS.BUSY),
			new Employee("���", 32, new BigDecimal(17000), STATUS.VOCATION),
			new Employee("������", 25, new BigDecimal(4800), STATUS.FREE),
			new Employee("����", 22, new BigDecimal(4000), STATUS.BUSY)
		);
	
	/**
	 *	��Լ
	 *	reduce(T, BinaryOperator) �����е�Ԫ�ؽ�������õ�һ��ֵ
	 */
	
	@Test
	public void test1() {
		System.out.println("test1 start...");

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer sumInteger = list.stream()
				.reduce(0, (x, y)->x+y);
		System.out.println(sumInteger);
		System.out.println("-------------total sum-----------------");
		
		Optional<Double> optional = listEmployee.stream()
			.map(x->x.getSalary().doubleValue())
		    .reduce(Double::sum);
		System.out.println(optional.get());
	}
	
	/**
	 * �ռ�
	 * collet, ����ת����������ʽ
	 */
	@Test
	public void test2() {
		System.out.println("----------test2------------------");
		List<String> list = listEmployee.stream()
			.map(Employee::getName)
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("----------------------------");
		Set<String> set = listEmployee.stream()
				.map(Employee::getName)
				.collect(Collectors.toSet());
			
		set.forEach(System.out::println);
		
		System.out.println("----------------------------");
		HashSet<String> hashSet = listEmployee.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));
			
		hashSet.forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		//����
		Long countLong = listEmployee.stream()
			.collect(Collectors.counting());
		System.out.println("counting sizze="+countLong);
		
		//ƽ��ֵ
		Double avgDouble = listEmployee.stream()
				.collect(Collectors.averagingInt(Employee::getAge));
		System.out.println("avg age="+avgDouble);
		
		//�ܺ�
		Double sumDouble = listEmployee.stream()
				.collect(Collectors.summingDouble(value->{
					return value.getSalary().doubleValue();
				}));
		System.out.println("sum salary="+sumDouble);
		
		//���ֵ
		Optional<Employee> maxValue = listEmployee.stream()
				.collect(Collectors.maxBy((x,y)->{
					return x.getSalary().compareTo(y.getSalary());
				}));
		System.out.println("max salary employee="+maxValue.get());
				
		//���ֵ
		Optional<Employee> minValue = listEmployee.stream()
				.collect(Collectors.minBy((x,y)->{
					return x.getSalary().compareTo(y.getSalary());
				}));
		System.out.println("min salary employee="+minValue.get());
		
	}
	
	//����
	@Test
	public void test4() {
		System.out.println("--------------test4--------------");
		Map<STATUS, List<Employee>> map = listEmployee.stream()
			.collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println("map="+map);
	}
	
	//�༶����
	@Test
	public void test5() {
		System.out.println("--------------test5--------------");
		Map<STATUS, Map<String, List<Employee>>> map = listEmployee.stream()
			.collect(Collectors.groupingBy(Employee::getStatus,  Collectors.groupingBy(e->{
				if(e.getAge()<=35) {
					return "����";
				}else {
					return "����";
				}
			})));
		System.out.println("map="+map);
		
	}
	
	//����
	@Test
	public void test6() {
		System.out.println("--------------test6--------------");
		Map<Boolean, List<Employee>> map = listEmployee.stream()
			.collect(Collectors.partitioningBy(e->e.getAge()>30));
		System.out.println("map="+map);
	}
	
	//ͳ��
	@Test
	public void test7() {
		System.out.println("--------------test7--------------");
		DoubleSummaryStatistics statistics = listEmployee.stream()
			.collect(Collectors.summarizingDouble(Employee::getAge));
		System.out.println("statistics="+statistics);
	}
	
	//����
	@Test
	public void test8() {
		System.out.println("--------------test8--------------");
		String strNames = listEmployee.stream()
		    .map(Employee::getName)
			.collect(Collectors.joining(","));
		System.out.println("strNames="+strNames);
	}
}