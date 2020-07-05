package com.vg.task15.optional;

public class Man {
	private String name;
	private Godness godness;
	
	public Man() {
		super();
	}
	public Man(String name, Godness godness) {
		super();
		this.name = name;
		this.godness = godness;
	}
	@Override
	public String toString() {
		return "Man [name=" + name + ", godness=" + godness + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Godness getGodness() {
		return godness;
	}
	public void setGodness(Godness godness) {
		this.godness = godness;
	}
	
	
}
