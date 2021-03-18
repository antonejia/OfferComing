package com.offer.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		final int count = 2000;
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();
		ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(count));
		final Random random = new Random();
		for (int i = 0; i < count; ++i){
			tp.execute(new Runnable(){
				public void run(){
					//synchronized (l) {
						l.add(random.nextInt());
					//}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		tp.shutdown();
		try {
			tp.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());

	}
	
	public static void main(String[] args){
		final int count = 10000;
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<Integer>();
		final Random random = new Random();
		
		for (int i = 0; i < count; ++i){
			Thread thread = new Thread(){
				@Override
				public void run() {
					l.add(random.nextInt());
				}				
				
			};
			thread.start();
			try {
				thread.join(); //join后其实是一个一个顺序执行的
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
		
	}

}
