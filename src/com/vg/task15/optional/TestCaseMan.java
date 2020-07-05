package com.vg.task15.optional;

import java.util.Optional;

import org.junit.Test;

public class TestCaseMan {

	@Test
	public void test1() {
		Man man = new Man("李四", new Godness("波多老师"));
		String nameString = getGodnessName(man);
		System.out.println("test1, name=" + nameString);
	}

	// 需求：获取一个男人心中女神的名字 (传统写法)
	public String getGodnessName(Man man) {
		if (man != null) {
			Godness godness = man.getGodness();
			if (godness != null) {
				return godness.getName();
			}
		}
		return null;
	}

	@Test
	public void test2() {
		NewMan man = new NewMan("张三", Optional.of(new Godness("苍老师")));
		String nameString = getGodnessNameNew(Optional.of(man));
		System.out.println("test2, name=" + nameString);
	}

	// 需求：获取一个男人心中女神的名字 (Optional写法)
	public String getGodnessNameNew(Optional<NewMan> man) {
		return man.orElse(new NewMan()).getGodness().orElse(new Godness()).getName();
	}
}
