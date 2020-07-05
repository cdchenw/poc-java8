package com.vg.task16.intf;

import org.junit.Test;

public class TestDeafultInterface {

	@Test
	public void test1() {
		MyClassChild child = new MyClassChild();
		System.out.println("test1, getName="+child.getName());
	}
	
	@Test
	public void test2() {
		MyClassChild1 child1 = new MyClassChild1();
		System.out.println("test2, getName="+child1.getName());
	}
	
	@Test
	public void test3() {
		MyClassChild1 child1 = new MyClassChild1();
		child1.show();
	}
}
