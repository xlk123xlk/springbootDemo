package com.product.method1;

public class Resource {

	//������Դ��
	static int num = 0;//��ǰ��Դ����
	static int max_size = 2000;//�����Դ����
	
	public synchronized void add() throws InterruptedException {
		if(num<max_size) {
			num++;
			System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ǰһ����"+num+"����Ʒ");
			notifyAll();//�����������߳̽�������
		}else {
			wait();//�����̵߳ȴ����ͷ���
			System.out.println(Thread.currentThread().getName()+"����ȴ�");
		}
	}
	
	public synchronized void remove() throws InterruptedException {
		if(num>0) {
			num--;
			System.out.println(Thread.currentThread().getName()+"������һ����Ʒ����ǰ��ʣ"+num+"����Ʒ");
			notifyAll();//���������߳̽�������
		}else {
			wait();
			System.out.println(Thread.currentThread().getName()+"����ȴ�");
		}
	}
}
