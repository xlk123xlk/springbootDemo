package com.concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

	/**
	 * Queue�ӿ���List��Setͬһ���𣬶��Ǽ̳���Collection�ӿ�
	   *   ��������BlockingQueue �̳���AbstractQueue ��AbstractQueue�����࣬ʵ����Queue��
	 * �����������У����Ǽ̳���AbstractQueue��
	 * LinkedBlockingQueue:��������Ķ��У��� FIFO���Ƚ��ȳ�������Ԫ�� 
	 * ArrayBlockingQueue:�ڹ���ʱ��Ҫָ�������� ������ѡ���Ƿ���Ҫ��ƽ�ԣ������ƽ����������true���ȴ�ʱ������̻߳����ȵõ�����
	   *   �������������ѭ���� �У��� FIFO���Ƚ��ȳ���ԭ���Ԫ�ؽ�������
	 * SynchronousQueue:
	 * PriorityBlockingQueue:��һ�������ȼ��� ���У��������Ƚ��ȳ�����
	 * DelayQueue:��һ�����Delayed Ԫ�ص��޽��������У�ֻ�����ӳ�����ʱ���ܴ�����ȡԪ��
	 * ����������
	 * priorityQueue
	 * ConcurrentLinkedQueue
	 */
	
	/**
	 * add         ����һ��Ԫ��                             ����������������׳�һ��IIIegaISlabEepeplian�쳣
����        remove      �Ƴ������ض���ͷ����Ԫ��       �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
����        element     ���ض���ͷ����Ԫ��                  �������Ϊ�գ����׳�һ��NoSuchElementException�쳣
����        offer       ���һ��Ԫ�ز�����true    ��������������򷵻�false
����        poll        �Ƴ������ʶ���ͷ����Ԫ��       �������Ϊ�գ��򷵻�null
����        peek        ���ض���ͷ����Ԫ��                   �������Ϊ�գ��򷵻�null
����        put         ���һ��Ԫ��                              �����������������
����       take         �Ƴ������ض���ͷ����Ԫ��      �������Ϊ�գ�������
	 */
	
	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");
		System.out.println(queue.peek());
		for(String name : queue) {
			System.out.println(name);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
