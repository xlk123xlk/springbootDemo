package com.product.method3;

public class Consumer extends Thread{

	private ResourceQueue r;
	
	public  Consumer(ResourceQueue r) {
		this.r = r;
	}
	
	public void run() {
		while(true) {
			r.remove();
		}
	}
}
