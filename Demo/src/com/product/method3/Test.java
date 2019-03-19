package com.product.method3;

public class Test {

	public static void main(String[] args) {
		ResourceQueue r = new ResourceQueue();
		Thread t1 = new Product(r);
		Thread t2 = new Consumer(r);
		t1.start();
		t2.start();
	}
}
