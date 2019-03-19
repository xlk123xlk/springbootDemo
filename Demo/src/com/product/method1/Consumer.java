package com.product.method1;

public class Consumer extends Thread{

	private Resource r;
	
	public Consumer(Resource r) {
		this.r = r;
	}
	
	public void run() {
		while(true) {
			try {
				r.remove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
