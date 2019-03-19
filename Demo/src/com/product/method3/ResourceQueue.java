package com.product.method3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ResourceQueue {

    private BlockingQueue  bq = new LinkedBlockingQueue(20000);
	
	public void add() {
		try {
			bq.put(1);
			System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ǰһ����"+bq.size()+"����Ʒ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void remove() {
		try {
			bq.take();
			System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ǰ��ʣ"+bq.size()+"����Ʒ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
