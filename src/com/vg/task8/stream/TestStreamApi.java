package com.vg.task8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.vg.task2.lambda.Employee;

/**
 * 1.stream的三个操作步骤
 * 
 * 1） 创建stream
 * 
 * 2）中间操作
 * 
 * 3） 终止操作
 *
 */
public class TestStreamApi {

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("王洪", 35, new BigDecimal(29000)),
			new Employee("李白", 32, new BigDecimal(17000)),
			new Employee("赵武", 31, new BigDecimal(12000)),
			new Employee("刘明明", 25, new BigDecimal(4800)),
			new Employee("洪吴", 22, new BigDecimal(4000))
		);
	
	//中间操作
	
	/**
	 * 1. 筛选与切片
	 * filter：接收lambda, 从流中排除某些元素
	 * limit：截断流，提取指定数量的元素
	 * skip(n)：跳过元素，返回一个扔掉了前面N个元素的流,若不足N个，则返回一个空的流
	 * distinct： 筛选，通过生成元素的hashCode()和equals() 去除重复结果
	 * 
	 */
	
	@Test
	public void test1() {
		System.out.println("test1 start...");
		listEmployee.stream()
			.filter((e)->e.getAge()>30) //中间操作
			.forEach(System.out::println); //终止操作：一次性执行全部内容，即"惰性求值"
	}
	
	//外部迭代
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
				System.out.println("test3 短路");
				return x.getSalary().compareTo(new BigDecimal(5000))>0;
			}).limit(2)
			.forEach(System.out::println);
	}
	
	@Test
	public void test4() {
		System.out.println("test4 start...");
		listEmployee.stream()
		.filter( (x) -> {
			System.out.println("test4 短路");
			return x.getSalary().compareTo(new BigDecimal(5000))>0;
		}).skip(2)
		.distinct()
		.forEach(System.out::println);
	}
}
