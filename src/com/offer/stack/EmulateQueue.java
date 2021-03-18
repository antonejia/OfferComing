package com.offer.stack;

import java.util.Stack;

public class EmulateQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public EmulateQueue(){
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
	}
	
	public void enqueue(Integer x){
		stack1.push(x);
	}
	
	public int dequeue() throws Exception{
		if (stack2.isEmpty()){
			if (stack1.isEmpty())
				throw new Exception("无元素了");
			while (!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		return stack2.pop();
	}
	
	public boolean isEmpty(){
		
		return stack1.isEmpty()&&stack2.isEmpty();
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmulateQueue emulateQueue = new EmulateQueue();
		emulateQueue.enqueue(1);
		System.out.println(emulateQueue.dequeue());
		emulateQueue.enqueue(2);
		System.out.println(emulateQueue.dequeue());
		emulateQueue.enqueue(3);
		
		System.out.println(emulateQueue.dequeue());
		System.out.println(emulateQueue.dequeue());
	}

}
