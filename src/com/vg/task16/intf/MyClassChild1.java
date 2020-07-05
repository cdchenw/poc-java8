package com.vg.task16.intf;

/**
 * 1.若继承两个接口，两个接口都有同名的默认方法，那么子类强制需要重写 方法
 *
 */
public class MyClassChild1 implements MyFun, MyFun2 {

	@Override
	public String getName() {
		return MyFun.super.getName();
	}

	public void show() {
		MyFun2.show(); // 直接调用接口的静态方法
	}

}
