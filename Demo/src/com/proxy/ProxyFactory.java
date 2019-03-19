package com.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//引spring-core-4.3.5包
//实现MethodInterceptor接口
public class ProxyFactory implements MethodInterceptor{

	private Object obj;
	
	public ProxyFactory(Object obj) {
		this.obj = obj;
	}
	
	//创建一个代理对象
	public Object getProxyInstance() {
		//1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(obj.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
	}
	
	@Override
	public Object intercept(Object arg0, Method m, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("开始事务...");
		//执行目标对象的方法
        Object returnValue = m.invoke(obj, null);
        System.out.println("提交事务...");
		return returnValue;
	}

}
