package com.vg.task15.optional;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;

import com.vg.task2.lambda.Employee;

public class TestOptional {

	/**
	 * Optional的常用方法
	 * 1) Optional.of(T t):	创建一个Optional实例 
	 *	2) Optional.empty():	创建一个空的Optional实例
	 *	3) Optional.ofNullable(T t): 若t不为null, 创建Optional实例，否者创建空实例
	 *	4) isPresent():	判断是否值存在
	 *	5)	orElse(T t):	如何调用对象包含值，则返回值，否者返回t
	 * 6) orElseGet(Supplier? supp)：如何调用对象包含值，则返回值，否者返回s获取的值
	 * 7) map(Function f):	 如果有值，对其进行处理，并返回处理后的Optonal,否者返回Optiona.empty();
	 * *) flatMap(Function f): 与map类似，要求返回值必须是Optional;
	 */
	@Test
	public void test1() {
		Optional<Employee> optional = Optional.of(new Employee("张三", 13, new BigDecimal(100000)));
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
//		Optional<Employee> optional = Optional.of(new Employee("张三", 13, new BigDecimal(100000)));
//		if(optional.isPresent()) {
//			System.out.println("test4, instance="+optional.get());
//		}
		
		Optional<Employee> optional = Optional.ofNullable(null);
		Employee employee = optional.orElse(new Employee("李四", 13, new BigDecimal(100000)));
		System.out.println("test4, instance="+employee);
	}
	
	@Test
	public void test5() {
		Optional<Employee> optional = Optional.ofNullable(null);
		Employee employee = optional.orElseGet(()->new Employee("赵武", 13, new BigDecimal(100000)));
		System.out.println("test5, instance="+employee);
	}
	
	@Test
	public void test6() {
		Optional<Employee> optional = Optional.ofNullable(new Employee("秦琪琪", 13, new BigDecimal(100000)));
		Optional<String> empName = optional.map((e)->e.getName());
		System.out.println("test6, empName="+empName.get());
	}
	
	@Test
	public void test7() {
		Optional<Employee> optional = Optional.ofNullable(new Employee("秦琪琪", 13, new BigDecimal(100000)));
		Optional<String> empName = optional.flatMap((e)->Optional.of(e.getName()));  //注意和上面tes6区别
		System.out.println("test7, empName="+empName.get());
	}
}
