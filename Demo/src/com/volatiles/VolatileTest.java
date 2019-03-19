package com.volatiles;

public class VolatileTest{

	public static volatile int race = 0;
	
	public static void increase() {
		 race++;
	}

	public static void main(String[] args) {
		Thread[] d = new Thread[20];//����20���߳�
		for(int i=0;i<20;i++) {
			d[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0;j<100000;j++) {
						increase();
					}
				}
			});
			d[i].start();//���߳�û��ִ��
		}
		//���߳����е��߳���������1ʱ��˵��ֻʣ�����߳�
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(race);
	}
}
