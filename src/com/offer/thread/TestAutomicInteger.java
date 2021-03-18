package com.offer.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAutomicInteger {

	public static AtomicInteger race = new AtomicInteger(500);
	public static void decrease(){
		race.decrementAndGet();
	}
	private static final int THREAD_COUNT = 50000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threads = new Thread[THREAD_COUNT];
		long cur1 = System.currentTimeMillis();
		for (int i = 0; i < THREAD_COUNT; i++){
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					decrease();
				}
			});
			threads[i].start();
		}
		
		while (Thread.activeCount()>1)
			Thread.yield();
		long cur2 = System.currentTimeMillis();
		System.out.println(cur2-cur1);
		System.out.println(race);
	}

}

/*public class TestAutomicInteger {

	public static int race = 500;
	public static synchronized void decrease(){
		race--;
	}
	private static final int THREAD_COUNT = 50000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] threads = new Thread[THREAD_COUNT];
		long cur1 = System.currentTimeMillis();
		for (int i = 0; i < THREAD_COUNT; i++){
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					decrease();
				}
			});
			threads[i].start();
		}
		
		while (Thread.activeCount()>1)
			Thread.yield();
		long cur2 = System.currentTimeMillis();
		System.out.println(cur2-cur1);
		System.out.println(race);
	}

}*/