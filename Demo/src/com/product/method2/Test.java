package com.product.method2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition productCondition = lock.newCondition();
		Condition consumerCondition = lock.newCondition();
		ResourceLock r = new ResourceLock(lock,productCondition,consumerCondition);
		Thread t1 = new ProductLock(r);
		Thread t2 = new ConsumerLock(r);
		t1.start();
		t2.start();
	}
}
