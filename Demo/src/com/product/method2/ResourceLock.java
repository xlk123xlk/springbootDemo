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
    		System.out.println(Thread.currentThread().getName()+"生产了一件产品，当前一共有"+num+"件产品");
    		consumerCondition.signalAll();//唤醒消费者线程进行消费
    	}else {
    		try {
				productCondition.await();
				System.out.println(Thread.currentThread().getName()+"进入等待");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public void remove() {
    	lock.lock();
    	if(num>0) {
    		num--;
    		System.out.println(Thread.currentThread().getName()+"消费了一件产品，当前还剩"+num+"件产品");
    		productCondition.signalAll();//唤醒生产者线程进行生产
    	}else {
    		try {
				consumerCondition.await();
				System.out.println(Thread.currentThread().getName()+"进入等待");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}
