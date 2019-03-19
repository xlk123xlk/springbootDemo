package com.singleton;

public class Singleton4 {

	private static Singleton4 s4 = null;
	
	private Singleton4() {}
	
	public static Singleton4 getSingleton4() {
		synchronized(Singleton4.class) {
			if(null==s4) {
				s4 = new Singleton4();
			}
			return s4;
		}
	}
}
