package com.xlk;

import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args) {
		Demo12 d12 = new Demo13();
		ProxyClient pc = new ProxyClient(d12);
		Demo12 dd = (Demo12) Proxy.newProxyInstance(Demo12.class.getClassLoader(), Demo12.class.getInterfaces(), pc);
	    dd.eat();
	    dd.getString("xlk");
	}
}
