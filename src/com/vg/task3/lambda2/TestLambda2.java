package com.vg.task3.lambda2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 1. lambda表达式基本语法： java8引入了一个新的操作符号-> ,该操作符成为箭头符号或lambda操作符
 *                                                箭头操作符将lambda表达式拆分成两部分
 *     左侧：参数列表
 *     右侧：表达式所需要执行的功能                                          
 *                    
 *      语法格式
 *      
 *      1) 无参数，无返回值
 *      （）-> System.out.println(“hello worlds”);               
 *      2) 有一个参数，无返回值，小括号可以省略
 *          x ->  System.out.println(“hello worlds” +x);     
 *        （x）->  System.out.println(“hello worlds” +x);                                    
 *      3) 有两个参数，并且lambda体重有多条语句，且有返回值
 *        （x, y） -> {
 *        		    //xxx,yyy
 *        			return xxx;
 *          };
* 	     4) 有两个参数，并且lambda体只有一条语句，return和大括号都可以省略
 *        （x, y） ->  xxx;
 *        
 *        lambda表达式的参数类型可以省略不写，JVM编译器会更具上下文推断出类型, 即“类型推断”
 *
 *     2. Lambda表达式需要函数式接口的支持
 *     函数式接口：接口中只有一个抽象方法的接口，成为函数式接口，可以使用注解@FunctionalInterface修饰
 *                          可以检查是否是函数式接口
 */
public class TestLambda2 {

	@Test
	public void test1() {
		//以前的方式
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hellow world");
			}
		};
		runnable.run();
		
		//lambda表达式方式
		Runnable r1 = ()-> System.out.println("hellow world");
		r1.run();
	}
	
	@Test
	public void test2() {
		Consumer<String> consumer = x->System.out.println("test2"+x);
		consumer.accept("测试2");
	}
	
	@Test
	public void test3() {
		Comparator<Integer> comparator = (x, y)->{
			return Integer.compare(x, y);
		};
		
		Comparator<Integer> comparator1 = (x, y)-> Integer.compare(x, y);
		
	}
	
	@Test
	public void test4() {
		String[] strsStrings  = {"aaaa", "bbb", "ccc"};  //类型推断
		
		List<String> list  = new ArrayList<>();  //类型推断
		
		show(new HashMap<>());//类型推断
	}
	
	public void show(Map<String, String> map) {
		
	}
	
	//需求：对一个数进行运算
	@Test
	public void test5() {
		Integer outInteger =operation(100, num->{
			return num * num;
		});
		System.out.println("test5, "+outInteger);
	}
	
	public  Integer operation(Integer num, MyFun mf) {
		return mf.formatValue(num);
	}
	
	
}
