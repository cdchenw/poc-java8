package com.vg.task15.optional;

import java.util.Optional;

import org.junit.Test;

public class TestCaseMan {

	@Test
	public void test1() {
		Man man = new Man("����", new Godness("������ʦ"));
		String nameString = getGodnessName(man);
		System.out.println("test1, name=" + nameString);
	}

	// ���󣺻�ȡһ����������Ů������� (��ͳд��)
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
		NewMan man = new NewMan("����", Optional.of(new Godness("����ʦ")));
		String nameString = getGodnessNameNew(Optional.of(man));
		System.out.println("test2, name=" + nameString);
	}

	// ���󣺻�ȡһ����������Ů������� (Optionalд��)
	public String getGodnessNameNew(Optional<NewMan> man) {
		return man.orElse(new NewMan()).getGodness().orElse(new Godness()).getName();
	}
}
