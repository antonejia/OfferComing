package com.offer.array;
/**
 * 	奇偶调序
	
	题目描述
	输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
	https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.06.md
 */
import java.util.Arrays;

public class OddEvenReverse {

	public static int[] oddEvenReverse(int[] a){
		if (a == null || a.length == 0){
			return null;	
		}
		int i = 0, j = a.length-1;
		while(i < j){
			while(a[i] % 2 == 1) i++;
			while(a[j] % 2 == 0) j--;
			if (i < j){
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		
		return a;
	}
	
	/**
	 * 快排一次划分的特殊思路
	 * @param a
	 * @return
	 */
	public static int[] patition(int[] a){
		if (a == null || a.length == 0){
			return null;	
		}
		int i = -1, privot = a[a.length-1];
		
		for (int j = 0; j < a.length-1; j++){
			if (a[j] < privot){
				swap(a, i+1, j);
				i++;
			}
		}
		
		swap(a, i+1, a.length-1);
		return a;
	}
	
	public static void swap(int[] a, int m, int n){
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}
	
	/**
	 * 类似于 快排一次划分的特殊思路
	 * @param a
	 * @return
	 */
	public static int[] oddEvenReverse2(int[] a){

		if (a == null || a.length == 0){
			return null;	
		}
		int i = -1;
		
		for (int j = 0; j < a.length-1; j++){
			if (a[j] % 2 == 1){
				swap(a, i+1, j);
				i++;
			}
		}
		
		//swap(a, i+1, a.length-1);
		return a;
	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 8,7, 1, 3, 5, 6, 4};
		//patition(a);
		System.out.println(Arrays.toString(patition(a)));
		System.out.println(Arrays.toString(oddEvenReverse(a)));
		System.out.println(Arrays.toString(oddEvenReverse2(a)));

	}

}
