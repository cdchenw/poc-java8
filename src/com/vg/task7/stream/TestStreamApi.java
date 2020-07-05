package com.vg.task7.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

	//����stream
	@Test
	public void test1() {
		//1. ����ͨ��Collectionϵ�м���ϵͳ��stream()����parallelStream()
		List<String> list = new ArrayList<String>();
		Stream<String> steam1 = list.stream();
		
		//2. ͨ��Arrays�ľ�̬����ת����stream
		Employee[] array = new Employee[10];
		Stream<Employee> steam2 = Arrays.stream(array);
		
		//3. ͨ��Stream���еľ�ͷ����of()
		Stream<String> stream3 = Stream.of("aa", "bb", "cc");
		
		//4. ����������
		//4.1 ����
		Stream<Integer> stream4 =  Stream.iterate(0, x->x+2);
		stream4.limit(10)
		.forEach(System.out::println);
		
		//4.2 ����
		Stream.generate(()->Math.random())
		.limit(5)
		.forEach(System.out::println);
		
	}
}
