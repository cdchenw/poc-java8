package com.vg.task16.intf;

public interface MyFun2 {

	// Ĭ�Ϸ���
	default String getName() {
		return "my fun 2";
	}

	// ��̬����
	public static void show() {
		System.out.println("my fun 2 show() static mehtod");
	}
}
