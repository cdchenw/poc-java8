package com.vg.task6.methodref;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.vg.task2.lambda.Employee;

/**
 * 1. �������ã� ��Lambda���ص����ݷ������Ѿ�ʵ���ˣ����ǿ���ʹ�á��������á�
 * (�������Ϊ����������lambda���ʽ������һ�ֱ�����ʽ)
 * 
 * ��Ҫ�������﷨��ʽ�� 
 * 	 1�����󣺣�ʵ��������
 *   2���ࣺ����̬������ 
 *   3���ࣺ��ʵ��������
 *   
 *   ע�⣺ 
 *   1�� lambda���ص��÷����Ĳ����б��뷵��ֵ���ͣ�Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ�£�
 *   2����һ��������ʵ�������ĵ����ߣ��ڶ���������ʵ�������Ĳ������ο�test4��
 *
 *2. ����������
 *    ClassName::new;
 *
 * 3.  ��������
 *   Type[]::new
 */
public class TestMethodRef {

	// ����::ʵ�������� sample1
	@Test
	public void test1() {
		PrintStream ps = System.out;

		Consumer<String> consumer = x -> ps.println(x);

		Consumer<String> consumer1 = ps::println;

		Consumer<String> consumer2 = System.out::println;

		consumer.accept("test1 way 111111");
		consumer1.accept("test1 way 22222");
		consumer2.accept("test1 way 33333");
	}

	// ����::ʵ�������� sample2
	@Test
	public void test2() {
		Employee emp = new Employee("����", 34, new BigDecimal(50000));
		Supplier<String> supplier = () -> emp.getName();
		System.out.println("test2 way1>>>" + supplier.get());

		Supplier<String> supplier1 = emp::getName;
		System.out.println("test2 way2>>>" + supplier1.get());

	}

	// ��::��̬������
	@Test
	public void test3() {
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);

		Comparator<Integer> comparator1 = Integer::compare;
		
		listNum.sort(comparator);
		
		System.out.println("test3>>>"+ listNum);
		
		listNum.sort(comparator1);
		System.out.println("test3>>>"+ listNum);
	}
	
	final List<Integer> listNum = Arrays.asList(
			13,21,33,14, 25
	);

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("����", 35, new BigDecimal(29000)),
			new Employee("���", 32, new BigDecimal(17000)), 
			new Employee("����", 31, new BigDecimal(12000)),
			new Employee("������", 25, new BigDecimal(4800))
	);
	
	//��::ʵ��������
	@Test
	public void test4() {
		BiPredicate<String, String> biPredicate =  (x,y)->x.equals(y);
		BiPredicate<String, String> biPredicate1 = String::equals;  //��һ��������ʵ�������ĵ����ߣ��ڶ���������ʵ�������Ĳ���
		
		if(biPredicate.test("abc", "abc")) {
			System.out.println("test4>>>abc equals abc");
		}
		
		if(!biPredicate1.test("abc", "bcd")) {
			System.out.println("test4>>>abc not equals bcd");
		}
		
	}
	
	//����������
	@Test
	public void test5() {
		Supplier<Employee> supplier = ()->new Employee();
		Supplier<Employee> supplier1 = Employee::new; //�����޲ι�����
		
		Employee employee = supplier.get();
		Employee employee1 = supplier1.get();
		
		System.out.println("test5 emp1>>>"+employee);
		System.out.println("test5 emp2>>>"+employee1);
		
	}
	
	//����������
	@Test
	public void test6() {
		Function<String, Employee> fun = name->new Employee(name);
		Function<String, Employee> fun1 = Employee::new;
		Employee employee2 = fun1.apply("����");
		System.out.println("test6 emp2>>>"+employee2);
		
		
		BiFunction<String, Integer, Employee> biFunction = (name, age)->new Employee(name, age);
		BiFunction<String, Integer, Employee> biFunction1 = Employee::new;
		Employee employee3 = biFunction1.apply("����",32);
		System.out.println("test6 emp3>>>"+employee3);
	}
	
	//��������
	@Test
	public void test7() {
		Function<Integer, String[]> fun = (x)->new String[x];
		String[] strsStrings = fun.apply(10);
		System.out.println("test7 array.length>>>"+strsStrings.length);
		
		Function<Integer, String[]> fun2 = String[]::new;
		String[] strsStrings1 = fun.apply(20);
		System.out.println("test7 array.length>>>"+strsStrings1.length);
 	}
}
