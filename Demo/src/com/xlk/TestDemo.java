package com.xlk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 得到 Class 的三种方式
		 */
		/*Demo11 d11 = new Demo11();
		Class c1 = d11.getClass();
		
		Class c2 = Demo11.class;*/
		
		Class c3 = Class.forName("com.xlk.Demo11");//会进行初始化
		
		Demo11 d11 = (Demo11) c3.newInstance();//创建对象
		
		String name = c3.getName();//获取Class对象名称
		
		Field [] fields = c3.getDeclaredFields();//获取属性值
		for(Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName());
		}
		Field field = c3.getDeclaredField("name");//获取私有属性
		field.setAccessible(true);
		field.set(d11, "Bob");//修改属性值
		System.out.println(field.get(d11));
		
		
		//获取方法
		Method[] ms = c3.getDeclaredMethods();
		for(Method m : ms) {
			System.out.println(m.getName());
		}
		Method m1 = c3.getMethod("eat", String.class);
		m1.invoke(d11, "xlk");
		System.out.println(name);
		
	}
}
