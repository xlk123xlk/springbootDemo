package com.Thread;

import java.util.concurrent.Callable;
/**
 * ��Runnable�ӿڲ�һ����Callable�ӿ��ṩ��һ��call����������Ϊ�߳�ִ���壬call()������run()��������Ҫǿ��
  call()���������з���ֵ
  call()�������������׳��쳣
 * 
 *
 */
public class Thread3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		return "come on!";
	}

}
