package com.vg.task15.optional;

import java.util.Optional;

public class NewMan {
	private String name;
	private Optional<Godness> godness = Optional.empty();

	public NewMan() {
		super();
	}

	public NewMan(String name, Optional<Godness> godness) {
		super();
		this.name = name;
		this.godness = godness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<Godness> getGodness() {
		return godness;
	}

	public void setGodness(Optional<Godness> godness) {
		this.godness = godness;
	}

	@Override
	public String toString() {
		return "NewMan [name=" + name + ", godness=" + godness + "]";
	}

}
