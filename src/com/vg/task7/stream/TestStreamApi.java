package com.vg.task7.stream;

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

	//创建stream
	@Test
	public void test1() {
		//1. 可以通过Collection系列集合系统的stream()或者parallelStream()
		List<String> list = new ArrayList<String>();
		Stream<String> steam1 = list.stream();
		
		//2. 通过Arrays的静态方法转换成stream
		Employee[] array = new Employee[10];
		Stream<Employee> steam2 = Arrays.stream(array);
		
		//3. 通过Stream类中的镜头方法of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");
		
		//4. 创建无限流
		//4.1 迭代
		Stream<Integer> stream4 =  Stream.iterate(0, x->x+2);
		stream4.limit(10)
		.forEach(System.out::println);
		
		//4.2 生成
		Stream.generate(()->Math.random())
		.limit(5)
		.forEach(System.out::println);
		
	}
}
