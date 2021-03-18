package com.offer.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 学习Atomic类的使用
 * @author bupt
 *
 */
public class Counter {

	//这是不用Atomic类而用一般synchronized加锁实现，效率比Atomic低
	/*private int count = 0;
	
	public int increase(){
		synchronized(this){
			count++;
		}
		return count;
	}
	
	public int decrease(){
		synchronized(this){
			count--;
		}
		return count;
	}*/
	
	public int getCount(){
		return count.intValue();
	}
	private AtomicInteger count = new AtomicInteger();
	public int increase(){
		
		return count.incrementAndGet();
	}
	
	public int decrease(){
		return count.decrementAndGet();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Counter counter = new Counter();
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++){
			exec.execute(new Runnable(){
				public void run(){
					counter.increase();
				}
			});
		}
		exec.shutdown();
		
		try {
			exec.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(counter.getCount());
	}
	

}
