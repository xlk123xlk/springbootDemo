package com.singleton;

/**
 * ����ģʽ��һ��
 * @author Administrator
 *
 */
public class Singleton1 {

	private static Singleton1 s1 = new Singleton1();
	
	private Singleton1() {}
	
	public static Singleton1 getSingleton1() {
		return s1;
	}
}
