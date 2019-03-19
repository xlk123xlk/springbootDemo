package com.singleton;

public class Singleton5 {

	private static  Singleton5 s5 = null;
	
	private Singleton5() {}
	
	public static synchronized Singleton5 getSingleton5() {
		if(null==s5) {
			s5 = new Singleton5();
		}
		return s5;
	}
}
