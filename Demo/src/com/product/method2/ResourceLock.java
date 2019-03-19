package com.product.method2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ResourceLock {

	private static int num = 0;
	private static int max_num = 20000;
    private Lock lock;
    private Condition productCondition;
    private Condition consumerCondition;
    
    public ResourceLock(Lock lock,Condition productCondition,Condition consumerCondition) {
    	this.lock = lock;
    	this.productCondition = productCondition;
    	this.consumerCondition = consumerCondition;
    }
    
    public void add() {
    	lock.lock();
    	if(num<max_num) {
    		num ++;
    		System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ǰһ����"+num+"����Ʒ");
    		consumerCondition.signalAll();//�����������߳̽�������
    	}else {
    		try {
				productCondition.await();
				System.out.println(Thread.currentThread().getName()+"����ȴ�");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public void remove() {
    	lock.lock();
    	if(num>0) {
    		num--;
    		System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ǰ��ʣ"+num+"����Ʒ");
    		productCondition.signalAll();//�����������߳̽�������
    	}else {
    		try {
				consumerCondition.await();
				System.out.println(Thread.currentThread().getName()+"����ȴ�");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}
