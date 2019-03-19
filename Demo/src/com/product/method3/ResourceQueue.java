package com.product.method3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ResourceQueue {

    private BlockingQueue  bq = new LinkedBlockingQueue(20000);
	
	public void add() {
		try {
			bq.put(1);
			System.out.println(Thread.currentThread().getName()+"生产了一件产品，当前一共有"+bq.size()+"件产品");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void remove() {
		try {
			bq.take();
			System.out.println(Thread.currentThread().getName()+"消费了一件产品，当前还剩"+bq.size()+"件产品");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
