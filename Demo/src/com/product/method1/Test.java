package com.product.method1;

public class Test {

	public static void main(String[] args) {
		Resource r = new Resource();
		Thread t1 = new Product(r);
		Thread t2 = new Consumer(r); 
		Thread t3 = new Product(r);
		t1.start();
		t2.start();
		t3.start();
	}
}
