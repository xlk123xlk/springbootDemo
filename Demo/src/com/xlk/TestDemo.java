package com.xlk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * �õ� Class �����ַ�ʽ
		 */
		/*Demo11 d11 = new Demo11();
		Class c1 = d11.getClass();
		
		Class c2 = Demo11.class;*/
		
		Class c3 = Class.forName("com.xlk.Demo11");//����г�ʼ��
		
		Demo11 d11 = (Demo11) c3.newInstance();//��������
		
		String name = c3.getName();//��ȡClass��������
		
		Field [] fields = c3.getDeclaredFields();//��ȡ����ֵ
		for(Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName());
		}
		Field field = c3.getDeclaredField("name");//��ȡ˽������
		field.setAccessible(true);
		field.set(d11, "Bob");//�޸�����ֵ
		System.out.println(field.get(d11));
		
		
		//��ȡ����
		Method[] ms = c3.getDeclaredMethods();
		for(Method m : ms) {
			System.out.println(m.getName());
		}
		Method m1 = c3.getMethod("eat", String.class);
		m1.invoke(d11, "xlk");
		System.out.println(name);
		
	}
}
