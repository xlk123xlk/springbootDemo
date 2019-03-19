package com.product.method2;

public class ProductLock extends Thread{

	private ResourceLock r ;
	
	public ProductLock (ResourceLock r) {
		this.r = r;
	}
	
	public void run() {
		while(true) {
			r.add();
		}
	}
}
