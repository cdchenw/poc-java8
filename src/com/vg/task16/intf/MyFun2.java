package com.vg.task16.intf;

public interface MyFun2 {

	// 默认方法
	default String getName() {
		return "my fun 2";
	}

	// 静态方法
	public static void show() {
		System.out.println("my fun 2 show() static mehtod");
	}
}
