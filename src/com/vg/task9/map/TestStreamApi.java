package com.vg.task9.map;

import java.math.BigDecimal;
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

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("����", 35, new BigDecimal(29000)),
			new Employee("���", 32, new BigDecimal(17000)),
			new Employee("����", 31, new BigDecimal(12000)),
			new Employee("������", 25, new BigDecimal(4800)),
			new Employee("����", 22, new BigDecimal(4000))
		);
	
	//�м����
	
	/**
	 * 2. ӳ��
	 * map: ����lambda,��Ԫ��ת����������ʽ����ȡ��Ϣ
	 * flatMap: ����һ��������Ϊ�ο��������е�ÿ��ֵ��ת������һ����,Ȼ�����е������ӳ�һ����
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
