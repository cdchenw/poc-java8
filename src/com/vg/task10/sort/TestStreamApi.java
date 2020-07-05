package com.vg.task10.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
			new Employee("赵武", 32, new BigDecimal(12000)),
			new Employee("李白", 32, new BigDecimal(17000)),
			new Employee("刘明明", 25, new BigDecimal(4800)),
			new Employee("洪吴", 22, new BigDecimal(4000))
		);
	
	//中间操作
	
	/**
	 * 3. 排序
	 * sorted() : 自然排序
	 * sorted(Comparator comp) : 定制排序
	 */
	@Test
	public void test7() {
		System.out.println("test7 start...");
		List<String> list = Arrays.asList("aaa", "yyy", "bbb", "xxx", "ccc");
		list.stream()
			.map(str->str.toUpperCase())
			.sorted()
			.forEach(System.out::println); 
		
		System.out.println("-----------------------------------------");
		
		listEmployee.stream()
			.sorted((x, y)->{ 
				if(x.getAge() == y.getAge()) {
					return x.getName().compareTo(y.getName());
				}else {
					return x.getAge() > y.getAge() ? 1 : -1;
				}
			})
			.forEach(System.out::println);
	}
	
}
