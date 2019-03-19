package com.xlk;

import java.lang.reflect.Method;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		DiskClassLoader disk = new DiskClassLoader("D:\\test");
		try {
			Class<?> c = disk.findClass("com.xlk.Test");
			System.out.println(c);
			if(c!=null) {
				Object obj = c.newInstance();
				Method m = c.getDeclaredMethod("say", null);
				m.invoke(obj, null);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
