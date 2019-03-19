package com.xlk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ¶¯Ì¬´úÀí
 * @author Administrator
 *
 */
public class ProxyClient implements InvocationHandler{

	private Object obj;
	
	public ProxyClient(Object obj) {
		this.obj = obj;
	}
	Object result;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("eat")) {
			hello();
			result = method.invoke(obj, null);
		}
		return result;
	}
	private void hello() {
		System.out.println("hello world");
	}

}
