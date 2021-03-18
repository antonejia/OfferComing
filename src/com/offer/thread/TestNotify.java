package com.offer.thread;

public class TestNotify {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Object obj = new Object();
		Thread t1 = new Thread(){
			public void run(){
				synchronized (obj) {
					try{
						System.out.println("Thread1 is to wake up");
						obj.wait();
						System.out.println("Thread1 wake up");
					}catch(InterruptedException e){
						
					}
				}
			}
		};
		t1.start();
		Thread.sleep(1000);//保证Thread1先起来
		Thread t2 = new Thread(){
			public void run(){
				synchronized (obj) {
					System.out.println("Thread2 is to sent notify");
					obj.notify();
					System.out.println("Thread2 sent notify");
					System.out.println("Thread2 sent notify");
					System.out.println("Thread2 sent notify");
					
					System.out.println("Thread2 sent notify");
				}
			}
		};
		t2.start();
		
	}

}
