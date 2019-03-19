package com.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//��spring-core-4.3.5��
//ʵ��MethodInterceptor�ӿ�
public class ProxyFactory implements MethodInterceptor{

	private Object obj;
	
	public ProxyFactory(Object obj) {
		this.obj = obj;
	}
	
	//����һ���������
	public Object getProxyInstance() {
		//1.������
        Enhancer en = new Enhancer();
        //2.���ø���
        en.setSuperclass(obj.getClass());
        //3.���ûص�����
        en.setCallback(this);
        //4.��������(�������)
        return en.create();
	}
	
	@Override
	public Object intercept(Object arg0, Method m, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("��ʼ����...");
		//ִ��Ŀ�����ķ���
        Object returnValue = m.invoke(obj, null);
        System.out.println("�ύ����...");
		return returnValue;
	}

}
