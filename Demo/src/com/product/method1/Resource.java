package com.product.method1;

public class Resource {

	//共享资源池
	static int num = 0;//当前资源数量
	static int max_size = 2000;//最大资源数量
	
	public synchronized void add() throws InterruptedException {
		if(num<max_size) {
			num++;
			System.out.println(Thread.currentThread().getName()+"生产了一件产品，当前一共有"+num+"件产品");
			notifyAll();//唤醒消费者线程进行消费
		}else {
			wait();//生产线程等待，释放锁
			System.out.println(Thread.currentThread().getName()+"进入等待");
		}
	}
	
	public synchronized void remove() throws InterruptedException {
		if(num>0) {
			num--;
			System.out.println(Thread.currentThread().getName()+"消费了一件产品，当前还剩"+num+"件产品");
			notifyAll();//唤醒生产线程进行生产
		}else {
			wait();
			System.out.println(Thread.currentThread().getName()+"进入等待");
		}
	}
}
