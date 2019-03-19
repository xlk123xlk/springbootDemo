package com.volatiles;

public class VolatileTest{

	public static volatile int race = 0;
	
	public static void increase() {
		 race++;
	}

	public static void main(String[] args) {
		Thread[] d = new Thread[20];//创建20条线程
		for(int i=0;i<20;i++) {
			d[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0;j<100000;j++) {
						increase();
					}
				}
			});
			d[i].start();//主线程没有执行
		}
		//当线程组中的线程数不大于1时，说明只剩下主线程
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(race);
	}
}
