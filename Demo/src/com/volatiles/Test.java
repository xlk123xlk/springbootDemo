package com.volatiles;

public class Test {

	volatile static int i = 0;
	public static void main(String[] args) {
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int j=0;j<40000;j++) {
					i++;
				}
			}
		});
		t2.start();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int k=0;k<50000;k++) {
					i++;
				}
			}
		});
		t1.start();
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(i);
	}
}
