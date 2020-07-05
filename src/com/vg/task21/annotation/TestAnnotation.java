package com.vg.task21.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 重复注解与类型注解
 *
 */
public class TestAnnotation {

	
	
	@MyAnnotation
	public void show( ) {
		System.out.println("show has been called");
	}
	
	@Test
	public void test1() throws NoSuchMethodException, SecurityException {
		Class<TestAnnotation> clazzClass = TestAnnotation.class;
		Method m1 = clazzClass.getMethod("show");
		MyAnnotation[] myAnnotation = m1.getAnnotationsByType(MyAnnotation.class);
		if(myAnnotation.length>0) {
			MyAnnotation my = myAnnotation[0];
			System.out.println(my.value());
		}
		
	}
}
