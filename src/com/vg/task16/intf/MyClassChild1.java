package com.vg.task16.intf;

/**
 * 1.���̳������ӿڣ������ӿڶ���ͬ����Ĭ�Ϸ�������ô����ǿ����Ҫ��д ����
 *
 */
public class MyClassChild1 implements MyFun, MyFun2 {

	@Override
	public String getName() {
		return MyFun.super.getName();
	}

	public void show() {
		MyFun2.show(); // ֱ�ӵ��ýӿڵľ�̬����
	}

}
