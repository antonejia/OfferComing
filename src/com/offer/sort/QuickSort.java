package com.offer.sort;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] a){
		if (a == null || a.length == 0)
			return ;
		partition(a, 0, a.length-1);

		System.out.println(Arrays.toString(a));
	}
	
	public static void partition (int[] a, int start, int end){
		if (start < end){//一开始忘掉了这个！！！！
			int i = start, j = end, p = a[start];
			while(i < j){
				while (i < j && a[j] >= p) j--;
					a[i] = a[j];
				while (i < j && a[i] <= p) i++;
					a[j] = a[i];
			}
			a[i] = p;
			
			partition(a, start, i-1);
			partition(a, i+1, end);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,8,2,1,6,9};
		quickSort(a);
	}

}
