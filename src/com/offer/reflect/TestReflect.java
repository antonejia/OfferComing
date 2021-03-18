package com.offer.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflect {

	private int field1;
	private int field2;
	
	
	public int add(int a, int b){
		return a + b;
	}
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// TODO Auto-generated method stub
		//构建对象：替代 new TestReflect()
		TestReflect testReflect = (TestReflect)Class.forName("com.offer.reflect.TestReflect").newInstance();
		
		//获取对象所属类
		Class clazz = testReflect.getClass();
		
		//获取类的信息
		Constructor[] constructors = clazz.getDeclaredConstructors();
		Method[] methods = clazz.getDeclaredMethods(); //仅自身类的方法
		Method[] methods2 = clazz.getMethods(); //包含父类的方法
		Field[] fields = clazz.getDeclaredFields();
		Field[] fields2 = clazz.getFields();
		System.out.println(Arrays.toString(constructors));
		System.out.println(Arrays.toString(methods));
		System.out.println(Arrays.toString(methods2));
		System.out.println(Arrays.toString(fields));
		System.out.println(Arrays.toString(fields2));
		
		//动态执行方法
		Method method = clazz.getDeclaredMethod("add", int.class, int.class);
		System.out.println(method.invoke(testReflect, 1, 2));
		
		//动态操作属性
		Field field1 = clazz.getDeclaredField("field1");
		field1.set(testReflect, 1); //这里，field的getter和setter方法并不是必要的
		
		System.out.println(testReflect.getField1());
	}
	public int getField1() {
		return field1;
	}
	/*public void setField1(int field1) {
		this.field1 = field1;
	}*/
	
	

}
