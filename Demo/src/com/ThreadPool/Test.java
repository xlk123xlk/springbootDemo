package com.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(5));
	    
		for(int i=0;i<15;i++) {
	    	MyTask mt = new MyTask(i); 
	    	executor.execute(mt);
	    	System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
	    }
		executor.shutdown();
	}
}
