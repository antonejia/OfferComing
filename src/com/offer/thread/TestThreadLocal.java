package com.offer.thread;
/**
 * Description: test ThreadLocal
 * @author bupt
 *
 */
public class TestThreadLocal {
	protected  static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		
		return seqNum.get();
	}
	
	private static class TestClient implements Runnable{
		private TestThreadLocal testThreadLocal;
		public TestClient(TestThreadLocal testThreadLocal){
			this.testThreadLocal = testThreadLocal;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 3; ++i){
				System.out.println("thread["+Thread.currentThread().getName()+"]sn["+testThreadLocal.getNextNum()+"]");
			}
		}
		
	}
	
	public static void main(String[] args){
		TestThreadLocal testThreadLocal = new TestThreadLocal();
		
		TestClient tc1 = new TestClient(testThreadLocal);
		TestClient tc2 = new TestClient(testThreadLocal);
		TestClient tc3 = new TestClient(testThreadLocal);
		
		new Thread(tc1).start();
		new Thread(tc2).start();
		new Thread(tc3).start();
	}
}
