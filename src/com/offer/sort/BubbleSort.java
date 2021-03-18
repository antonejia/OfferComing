package com.offer.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int[] a){
		int tmp;
		for (int i = 1; i <= a.length-1; i++){
			for (int j = 0; j <= a.length-1-i; j++){
				if (a[j]>a[j+1]){
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,8,2,1,5,6};
		bubbleSort(a);
	}

}
