package com.offer.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caculator calc = new CaculatorImpl();
		LogHandler lh = new LogHandler(calc);
		Caculator calcProxy = (Caculator)Proxy.newProxyInstance(
				calc.getClass().getClassLoader(), //注意这里的参数不是Caculator.class（接口）
				calc.getClass().getInterfaces(), 
				lh);
		System.out.println(calcProxy.add(1, 2));

	}
	

}

interface Caculator{
	public int add(int a, int b);
}

class CaculatorImpl implements Caculator{
	public int add(int a, int b){
		return a + b;
	}
}

class LogHandler implements InvocationHandler{
	private Object obj;
	
	public LogHandler(Object obj){
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		doBefore();
		Object o = method.invoke(obj, args);//这里是obj，不是proxy
		doAfter();
		return o;
	}
	
	public void doBefore(){
		System.out.println("doBefore");
	}
	
	public void doAfter(){
		System.out.println("doAfter");
	}
	
}