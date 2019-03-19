package com.concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

	/**
	 * Queue接口与List、Set同一级别，都是继承了Collection接口
	   *   阻塞队列BlockingQueue 继承了AbstractQueue （AbstractQueue抽象类，实现了Queue）
	 * 五种阻塞队列（都是继承了AbstractQueue）
	 * LinkedBlockingQueue:基于链表的队列，按 FIFO（先进先出）排序元素 
	 * ArrayBlockingQueue:在构造时需要指定容量， 并可以选择是否需要公平性，如果公平参数被设置true，等待时间最长的线程会优先得到处理
	   *   基于数组的阻塞循环队 列，按 FIFO（先进先出）原则对元素进行排序。
	 * SynchronousQueue:
	 * PriorityBlockingQueue:是一个带优先级的 队列，而不是先进先出队列
	 * DelayQueue:是一个存放Delayed 元素的无界阻塞队列，只有在延迟期满时才能从中提取元素
	 * 非阻塞队列
	 * priorityQueue
	 * ConcurrentLinkedQueue
	 */
	
	/**
	 * add         增加一个元索                             如果队列已满，则抛出一个IIIegaISlabEepeplian异常
　　        remove      移除并返回队列头部的元素       如果队列为空，则抛出一个NoSuchElementException异常
　　        element     返回队列头部的元素                  如果队列为空，则抛出一个NoSuchElementException异常
　　        offer       添加一个元素并返回true    如果队列已满，则返回false
　　        poll        移除并返问队列头部的元素       如果队列为空，则返回null
　　        peek        返回队列头部的元素                   如果队列为空，则返回null
　　        put         添加一个元素                              如果队列满，则阻塞
　　       take         移除并返回队列头部的元素      如果队列为空，则阻塞
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
