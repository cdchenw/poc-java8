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
 * 1. 方法引用： 若Lambda体重的内容方法以已经实现了，我们可以使用“方法引用”
 * (可以理解为方法引用是lambda表达式的另外一种表现形式)
 * 
 * 主要有三种语法格式： 
 * 	 1）对象：：实力方法名
 *   2）类：：静态方法名 
 *   3）类：：实例方法名
 *   
 *   注意： 
 *   1） lambda体重调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 *   2）第一个参数是实例方法的调用者，第二个参数是实例方法的参数（参考test4）
 *
 *2. 构造器引用
 *    ClassName::new;
 *
 * 3.  数组引用
 *   Type[]::new
 */
public class TestMethodRef {

	// 对象::实例方法名 sample1
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

	// 对象::实例方法名 sample2
	@Test
	public void test2() {
		Employee emp = new Employee("张三", 34, new BigDecimal(50000));
		Supplier<String> supplier = () -> emp.getName();
		System.out.println("test2 way1>>>" + supplier.get());

		Supplier<String> supplier1 = emp::getName;
		System.out.println("test2 way2>>>" + supplier1.get());

	}

	// 类::静态方法名
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
			new Employee("王洪", 35, new BigDecimal(29000)),
			new Employee("李白", 32, new BigDecimal(17000)), 
			new Employee("赵武", 31, new BigDecimal(12000)),
			new Employee("刘明明", 25, new BigDecimal(4800))
	);
	
	//类::实例方法名
	@Test
	public void test4() {
		BiPredicate<String, String> biPredicate =  (x,y)->x.equals(y);
		BiPredicate<String, String> biPredicate1 = String::equals;  //第一个参数是实例方法的调用者，第二个参数是实例方法的参数
		
		if(biPredicate.test("abc", "abc")) {
			System.out.println("test4>>>abc equals abc");
		}
		
		if(!biPredicate1.test("abc", "bcd")) {
			System.out.println("test4>>>abc not equals bcd");
		}
		
	}
	
	//构造器引用
	@Test
	public void test5() {
		Supplier<Employee> supplier = ()->new Employee();
		Supplier<Employee> supplier1 = Employee::new; //调用无参构造器
		
		Employee employee = supplier.get();
		Employee employee1 = supplier1.get();
		
		System.out.println("test5 emp1>>>"+employee);
		System.out.println("test5 emp2>>>"+employee1);
		
	}
	
	//构造器引用
	@Test
	public void test6() {
		Function<String, Employee> fun = name->new Employee(name);
		Function<String, Employee> fun1 = Employee::new;
		Employee employee2 = fun1.apply("张三");
		System.out.println("test6 emp2>>>"+employee2);
		
		
		BiFunction<String, Integer, Employee> biFunction = (name, age)->new Employee(name, age);
		BiFunction<String, Integer, Employee> biFunction1 = Employee::new;
		Employee employee3 = biFunction1.apply("张三",32);
		System.out.println("test6 emp3>>>"+employee3);
	}
	
	//数组引用
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
