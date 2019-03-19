package com.xlk;

public class Demo{

	public static int i = 1;
	
	static {
		System.out.println("xixi");
		init();
	}
	
	public static void init() {
		System.out.println("2222");
	}
	
	public static String getName() {
		return "xlk";
	}
}
