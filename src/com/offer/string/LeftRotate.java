package com.offer.string;

import java.util.Arrays;

/**
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符“ab” 移动到字符串的尾部，即变成“cdefab”。
 * 请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * 
 * @author bupt
 *
 */
public class LeftRotate {
	public void reverse(char[] chars, int start, int end){
		
		/*if (start > end){
			return;
		} //这个判断多余，因为如果start>end,下面的while就进不了
		if (end >= chars.length ){
			return ;
		} *///这个判断也多余，因为所有调用reverse函数的地方，都能保证end < chars.length
		
		while(start < end){
			char tmp = chars[start];
			chars[start++] = chars[end];
			chars[end--] = tmp;
		}
	}
	
	public void leftRotate(char[] chars, int m){
		if (chars == null || chars.length == 0){
			return ;
		}
		m = m % chars.length; //若要左移动大于n位，那么和%n 是等价的
		reverse(chars, 0, m-1);
		System.out.println(Arrays.toString(chars));
		reverse(chars, m, chars.length-1);
		System.out.println(Arrays.toString(chars));
		reverse(chars, 0, chars.length-1);
	}
	
	/**
	 * 以下代码，String做为形参传递进来，尽管在函数内对string重新定义，对函数外string仍是不变的
	 * 因为string是不可变类（采用字符数组char[]实现，在string源码内，char[]是string的一个属性，被定义为final
	 * 另外，String类本身也是final的，即不可被继承），Integer，Long等基本类型包装类具有同样的特性 
	 * @param string
	 */
	public static void changeString(String string){
		string = "agee";
	}
	
	public static void main(String[] args){
		LeftRotate leftRotate = new LeftRotate();
		String string = "gefaa";
		///LeftRotate.changeString(string);
		char [] chars = string.toCharArray();//注意这里，因为String是不可变类，不能直接将它作为形参传递，所以将其转换为char数组
		leftRotate.leftRotate(chars, 3);
		
		System.out.println(new String(chars));
		System.out.println(chars.toString());
	}
}
