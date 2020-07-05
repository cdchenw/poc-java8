package com.vg.task3.lambda2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * 1. lambda���ʽ�����﷨�� java8������һ���µĲ�������-> ,�ò�������Ϊ��ͷ���Ż�lambda������
 *                                                ��ͷ��������lambda���ʽ��ֳ�������
 *     ��ࣺ�����б�
 *     �Ҳࣺ���ʽ����Ҫִ�еĹ���                                          
 *                    
 *      �﷨��ʽ
 *      
 *      1) �޲������޷���ֵ
 *      ����-> System.out.println(��hello worlds��);               
 *      2) ��һ���������޷���ֵ��С���ſ���ʡ��
 *          x ->  System.out.println(��hello worlds�� +x);     
 *        ��x��->  System.out.println(��hello worlds�� +x);                                    
 *      3) ����������������lambda�����ж�����䣬���з���ֵ
 *        ��x, y�� -> {
 *        		    //xxx,yyy
 *        			return xxx;
 *          };
* 	     4) ����������������lambda��ֻ��һ����䣬return�ʹ����Ŷ�����ʡ��
 *        ��x, y�� ->  xxx;
 *        
 *        lambda���ʽ�Ĳ������Ϳ���ʡ�Բ�д��JVM������������������ƶϳ�����, ���������ƶϡ�
 *
 *     2. Lambda���ʽ��Ҫ����ʽ�ӿڵ�֧��
 *     ����ʽ�ӿڣ��ӿ���ֻ��һ�����󷽷��Ľӿڣ���Ϊ����ʽ�ӿڣ�����ʹ��ע��@FunctionalInterface����
 *                          ���Լ���Ƿ��Ǻ���ʽ�ӿ�
 */
public class TestLambda2 {

	@Test
	public void test1() {
		//��ǰ�ķ�ʽ
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hellow world");
			}
		};
		runnable.run();
		
		//lambda���ʽ��ʽ
		Runnable r1 = ()-> System.out.println("hellow world");
		r1.run();
	}
	
	@Test
	public void test2() {
		Consumer<String> consumer = x->System.out.println("test2"+x);
		consumer.accept("����2");
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
		String[] strsStrings  = {"aaaa", "bbb", "ccc"};  //�����ƶ�
		
		List<String> list  = new ArrayList<>();  //�����ƶ�
		
		show(new HashMap<>());//�����ƶ�
	}
	
	public void show(Map<String, String> map) {
		
	}
	
	//���󣺶�һ������������
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
