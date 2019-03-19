package com.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		/*Thread t1 = new Thread1();
		t1.start();
		Thread t2 = new Thread(new Thread2());
		t2.start();
		Thread3 t3 = new Thread3();
		FutureTask<String>  ft = new FutureTask<String>(t3);
		try {
			new Thread(ft).start();
			String result = ft.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}*/
		
		ReentrantLock lock = new ReentrantLock();
		Condition conditionA = lock.newCondition();
		Condition conditionB = lock.newCondition();
		Condition conditionC = lock.newCondition();
		Thread ta = new Thread(new LockPrinter(lock,conditionA,conditionB,'A'));
		Thread tb = new Thread(new LockPrinter(lock,conditionB,conditionC,'B'));
		Thread tc = new Thread(new LockPrinter(lock,conditionC,conditionA,'C'));
		ta.start();
		ta.sleep(100);
		tb.start();
		tb.sleep(100);
		tc.start();
		tc.sleep(100);
	}
}
