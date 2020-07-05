package com.vg.task9.map;

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
			new Employee("李白", 32, new BigDecimal(17000)),
			new Employee("赵武", 31, new BigDecimal(12000)),
			new Employee("刘明明", 25, new BigDecimal(4800)),
			new Employee("洪吴", 22, new BigDecimal(4000))
		);
	
	//中间操作
	
	/**
	 * 2. 映射
	 * map: 接受lambda,将元素转换成其他形式或提取信息
	 * flatMap: 接收一个函数作为参考，将流中的每个值都转成另外一个流,然后将所有的流链接成一个流
	 */
	@Test
	public void test5() {
		System.out.println("test5 start...");
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		list.stream()
			.map(str->str.toUpperCase())
			.forEach(System.out::println); 
		
		System.out.println("-----------------------------------------");
		
		listEmployee.stream()
			.map(emp->emp.getName())
			.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		Stream<Stream<Character>> stream =list.stream().map(this::filterCharaStream);
		stream.forEach(sm->{
			sm.forEach(System.out::println);
		});
		
		System.out.println("-----------------------------------------");
		
		list.stream()
			.flatMap(this::filterCharaStream)
			.forEach(System.out::println);
			
	}
	
	@Test
	public void test6() {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		
		
	}
	
	public Stream<Character> filterCharaStream(String str){
		List<Character> list = new ArrayList<Character>();
		for(Character c: str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}
	
	
	
	
	
	
}
