package com.singleton;

/**
 * ����ʽ  ������(�̲߳���ȫ)
 * @author Administrator
 *
 */
public class Singleton3 {

	private static Singleton3 s3 = null;
	
	private Singleton3() {}
	
	public static Singleton3 getSingleton3() {
		if(null==s3) {
			s3 = new Singleton3();
		}
		return s3;
	}
}
