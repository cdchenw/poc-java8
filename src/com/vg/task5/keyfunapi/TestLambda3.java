package com.vg.task5.keyfunapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 *   Java 8 �����Ĵ���ĺ���ʽ�ӿ�
 *   
 *   Consumer<T>:  �����ͽӿ�
 *       void accept(T t);
 *   Supplier<T>:�����ͽӿ�
 *       T get();
 *    Function<T, R>: �����ͽӿ�
 *       R apply<T t>;
 *    Predicate<T>: �����ͽӿ�
 *        boolean test(T t);
 *
 */
public class TestLambda3 {
	
	//�����ͽӿ�
	@Test
	public void test1() {
		happy(10000, x->{
			System.out.println("consumer test1>>"+x);
		});
	}
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	//�����ͽӿ�
	@Test
	public void test2() {
		List<Integer> list = getNumList(10, ()->{
			return (int)(Math.random() * 100);
		});
		
		for(Integer num: list) {
			System.out.println("test2>>"+num);
		}
	}
	
	//����ָ�������������������뼯����
	public List<Integer> getNumList(int num, Supplier<Integer> supp){
		List<Integer> list  = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			list.add(supp.get());
		}
		return list;
	}
	
	//�����ͽӿ�
	@Test
	public void test3() {
		String newString = strHandle("\t\t\t �ҵĲ��� ", x->{
			return x.trim();
		});
		System.out.println("test3>>"+newString);
		
		String subString = strHandle("�ҵĲ��Ժ���", x->{
			return x.substring(2, 5);
		});
		System.out.println("test3>>"+subString);
	}
	
	//����ר�Ŵ����ַ���
	public String strHandle(String str, Function<String, String> fun) {
		return fun.apply(str);
	}
	
	//�����ͽӿ�
	@Test
	public void test4() {
		List<String> list = Arrays.asList("hello", "atguigu", "lambda", "www");
		List<String> list1 = filterStr(list, x->x.length()>10);
	}
	
	//�������������ַ�����ӵ�һ��������
	public List<String> filterStr(List<String> list,  Predicate<String> pre){
		List<String> strList = new ArrayList<String>();
		for(String str: list) {
			if(pre.test(str)) {
				strList.add(str);
			}
		}
		return strList;
	};
}
