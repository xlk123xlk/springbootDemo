package com.product.method1;

public class Product extends Thread{

	private Resource r;
	
	public Product (Resource r) {
		this.r = r;
	}
	
	public void run() {
		while(true) {
			try {
				r.add();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
