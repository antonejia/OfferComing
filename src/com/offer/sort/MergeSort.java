package com.offer.sort;

import java.util.Arrays;


public class MergeSort {
	//排序a[start:end] 包括end
	public static int[] mergeSort(int[] a, int start, int end){
		if (start >= end)
			return Arrays.copyOfRange(a, start, end+1); //end + 1
		
		int mid = (start+end)/2;
		int[] left = mergeSort(a, start, mid);
		int[] right = mergeSort(a, mid+1, end);
		
		return mergeTwoArrays(left, right);
	}
	
	public static int[] mergeTwoArrays(int[] a, int[] b){
		int[] c = new int[a.length+b.length];
		int ic = 0;
		int ia = 0, ib = 0;
		for (; ia < a.length && ib <b.length; ){
			if (a[ia] < b[ib]){
				c[ic++] = a[ia++];
			}else {
				c[ic++] = b[ib++];
			}
		}
		
		for (;ia < a.length;)
			c[ic++] = a[ia++];
		for (;ib < b.length;)
			c[ic++] = b[ib++];
		
		return c;	
	}
	
	public static void main(String[] args) {
		int[] a = {10,4,5,3,13};
		
		System.out.println(Arrays.toString(mergeSort(a, 0, a.length-1)));
	}

}
