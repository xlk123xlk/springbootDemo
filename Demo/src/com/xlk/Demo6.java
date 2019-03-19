package com.xlk;

import java.io.Serializable;

public class Demo6 implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	
	private int age;

	public Demo6(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
