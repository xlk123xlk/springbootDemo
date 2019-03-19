package com.singleton;
/**
 * ¾²Ì¬ÄÚ²¿Àà
 * @author Administrator
 *
 */
public class Singleton6 {

	private Singleton6() {}
	
	private static class Singleton6Instance {
		private final static Singleton6 s6 = new Singleton6();
	}
	
	public static Singleton6 getSingleton6() {
		System.out.println("111");
		return Singleton6Instance.s6;
	}
}


