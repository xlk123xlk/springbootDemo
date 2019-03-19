package com.product.method2;

public class ConsumerLock extends Thread{
	
	private ResourceLock r;
	
	public ConsumerLock(ResourceLock r) {
		this.r = r;
	}

	public void run () {
		while(true) {
			r.remove();
		}
	}
}
