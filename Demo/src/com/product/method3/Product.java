package com.product.method3;

public class Product extends Thread{

	private ResourceQueue r ;
	
	public Product(ResourceQueue r) {
		this .r = r;
	}
	
	public void run() {
		while(true) {
			r.add();
		}
	}
}
