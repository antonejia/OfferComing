package com.offer.Integer;

public class TestIntAndInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		Integer iInteger = new Integer(i);
		Integer jInteger = new Integer(i);
		//System.out.println(i == ii);//true
		//System.out.println(jj == ii);
		Integer i0 = 127;
		int i00 = 127;
		Integer i000 = 127;
		Integer i1 = 128;
		int i11 = 128;
		Integer i111 = 128;
		System.out.println(i0 == i00);//true
		System.out.println(i0 == i000);//true
		System.out.println(i1 == i11);//true
		System.out.println(i1 == i111);//false Integer会对-128~127的对象做缓存
		
		
	}

}
