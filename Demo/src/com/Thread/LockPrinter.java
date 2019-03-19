package com.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 连续打印abc10次
 * @author Administrator
 *
 */
public class LockPrinter implements Runnable{

	private final int size =10;
	
	private final ReentrantLock lock;
	
	private final Condition condition;
	
	private final Condition nextCondition;
	
	private final char printChar;
	
	public LockPrinter(ReentrantLock lock,Condition condition,Condition nextCondition,char printChar) {
		this.lock = lock;
		this.condition = condition;
		this.nextCondition = nextCondition;
		this.printChar = printChar;
	}
	@Override
	public void run() {
		lock.lock();
		try {
			for(int i=0;i<size;i++) {
				System.out.print(printChar);
				nextCondition.signalAll();//唤醒下个线程
				if(i<size-1) {
					condition.await();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
