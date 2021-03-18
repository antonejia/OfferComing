package com.offer.sort;

import java.util.Arrays;

public class HeapSort {

	public static void heapSort(int[] a){
		int len = a.length;
		for (int i = 0; i < len-1; i++){
			//create heap
			helper3(a, len-1-i);
			//swap a[0] and a[len-1-i]
			swap(a, 0, len-1-i);
		}
	}
	
	public static void swap(int[] a, int m, int n){
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}
	
	public static void helper(int[] a, int endIndex){
		for (int i = (endIndex-1)/2; i >= 0; i--){
			int p = i;
			while (p*2+1 <= endIndex){
				int biggerIndex = p*2+1;
				if (p*2+2 <= endIndex){
					if (a[p*2+2] > a[p*2+1])
						biggerIndex = p*2+2;
				}
				if (a[p] < a[biggerIndex]){
					swap(a, p, biggerIndex);
					p = biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	
	public static void helper2(int[] a, int endIndex){
		for (int i = (endIndex-1)/2; i >= 0; i--){
			int p = i;
			while (p*2+1 <= endIndex){
				int biggerIndex = p*2+1;
				//biggerIndex保存p的左右孩子较大值的index（右孩子为空，直接返回左孩子index）
				biggerIndex = (biggerIndex+1 > endIndex)? biggerIndex:(a[biggerIndex+1]>a[biggerIndex]?biggerIndex+1:biggerIndex);
				
				if (a[p] < a[biggerIndex]){
					swap(a, p, biggerIndex);
					p = biggerIndex;
				}else{
					break;
				}
			}
		}
	}
	/**
	 * 写法3：不用swap，类似于快排中的过程
	 * @param a
	 * @param endIndex
	 */
	public static void helper3(int[] a, int endIndex){
		for (int i = (endIndex-1)/2; i >= 0; i--){
			int p = i;
			int tmp, biggerIndex;
			for (tmp = a[p]; p*2+1 <= endIndex; p = biggerIndex){
				biggerIndex = p*2+1;
				if (biggerIndex != endIndex && a[biggerIndex+1] > a[biggerIndex]){
					biggerIndex++;
				}
				if (a[p] < a[biggerIndex]){
					a[p] = a[biggerIndex];
				}else {
					break;
				}
			}
			//!!!, 莫忘
			a[p] = tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,8,2,1,6,9};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

}
