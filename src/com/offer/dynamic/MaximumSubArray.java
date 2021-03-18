package com.offer.dynamic;

/**
 * http://blog.csdn.net/linhuanmars/article/details/21314059
 * @author bupt
 *
 */
public class MaximumSubArray {

	public static int maxSubArray(int[] A){
		if (A == null || A.length == 0)
			return -1;
		int[] r = new int[A.length];//r[i]保存以s[i]为结尾的最大子数组和，最终结果为这个数组的最大值
		r[0] = A[0];
		int max = r[0];
		for (int i = 1; i < A.length; i++){
			if (r[i-1] <= 0)
				r[i] = A[i];
			else {
				r[i] = A[i] + r[i-1];
			}
			max = Math.max(r[i], max);
		}
		
		return max;
	}
	
	public static int maxSubArray1(int[] A){
		if (A == null || A.length == 0)
			return -1;
		int r = A[0];
		int max = A[0];
		for (int i = 1; i < A.length; i++){
			if (r <= 0)
				r = A[i];
			else {
				r = A[i] + r;
			}
			max = Math.max(r, max);
		}
		
		return max;
	}

	public static int maxSubArray2(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -1;
		}

		int[] r = new int[arr.length - 1];
		r[0] = arr[0];

		int max = r[0];
		for(int i = 1; i < arr.length; i++) {
			if(r[i-1] >= 0) {
				r[i] = r[i-1] + arr[i];
			} else {
				r[i] = arr[i];
			}

			max = Math.max(max, r[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray2(arr));

	}

}
