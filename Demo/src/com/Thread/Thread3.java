package com.Thread;

import java.util.concurrent.Callable;
/**
 * 和Runnable接口不一样，Callable接口提供了一个call（）方法作为线程执行体，call()方法比run()方法功能要强大。
  call()方法可以有返回值
  call()方法可以声明抛出异常
 * 
 *
 */
public class Thread3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		return "come on!";
	}

}
