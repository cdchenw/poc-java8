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
 *   Java 8 内置四大核心函数式接口
 *   
 *   Consumer<T>:  消费型接口
 *       void accept(T t);
 *   Supplier<T>:供给型接口
 *       T get();
 *    Function<T, R>: 函数型接口
 *       R apply<T t>;
 *    Predicate<T>: 断言型接口
 *        boolean test(T t);
 *
 */
public class TestLambda3 {
	
	//消费型接口
	@Test
	public void test1() {
		happy(10000, x->{
			System.out.println("consumer test1>>"+x);
		});
	}
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	//供给型接口
	@Test
	public void test2() {
		List<Integer> list = getNumList(10, ()->{
			return (int)(Math.random() * 100);
		});
		
		for(Integer num: list) {
			System.out.println("test2>>"+num);
		}
	}
	
	//产生指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> supp){
		List<Integer> list  = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			list.add(supp.get());
		}
		return list;
	}
	
	//函数型接口
	@Test
	public void test3() {
		String newString = strHandle("\t\t\t 我的测试 ", x->{
			return x.trim();
		});
		System.out.println("test3>>"+newString);
		
		String subString = strHandle("我的测试函数", x->{
			return x.substring(2, 5);
		});
		System.out.println("test3>>"+subString);
	}
	
	//用于专门处理字符串
	public String strHandle(String str, Function<String, String> fun) {
		return fun.apply(str);
	}
	
	//断言型接口
	@Test
	public void test4() {
		List<String> list = Arrays.asList("hello", "atguigu", "lambda", "www");
		List<String> list1 = filterStr(list, x->x.length()>10);
	}
	
	//将满足条件的字符串添加到一个集合中
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
