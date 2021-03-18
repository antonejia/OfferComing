package com.offer.search;

public class SearchInsertPosition {

	public static int searchInsert(int[] A, int target){
		if (A.length == 0)
			return 0;
		
		int i = 0;
		while (i < A.length && A[i] < target)
			i++;
		
		return i;
	}
	
	/**
	 * 二分法（写法1）
	 * @return
	 */
	public static int searchInsert2(int[] A, int target){
		if (A.length == 0)
			return 0;
		
		return helper(A, 0, A.length-1, target);
	}
	
	public static int helper(int[] A, int start, int end, int target){
		if (start > end){//!!!!重要，不可缺少，否则当要找元素target不存在时，递归无法结束
			return start;
		}
		
		int mid = (start + end) / 2;
		if (A[mid] == target)
			return mid;
		else if (A[mid] < target){
			return helper(A, mid+1, end, target);
			
		}else {
			return helper(A, start, mid-1, target);
			
		}
		
	}
	/**
	 * 二分法（写法2：比较好）
	 * http://blog.csdn.net/linhuanmars/article/details/20278967
	 * 此方法优点：
	 * 当循环结束时，假设要找元素不存在，那么start正好指向比target大的起始元素，end正好指向比target小的最末元素，即target正好处于end和start之间（此时end< start）
	 * @param A
	 * @param target
	 * @return
	 */
	public static int searchInsert3(int[] A, int target){
		if (A == null || A.length == 0)
			return 0;
		
		int start = 0, end = A.length-1, mid;
		
		while (start <= end){//注意等号
			mid = start + ((end-start)>>1);
			//mid = (start+end)/2;
			if (A[mid] < target){
				start = mid+1;
			}else if (A[mid] > target){
				end = mid-1;
			}else {
				return mid;
			}
		}
		
		return start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1};
		int target = 2;
		
		System.out.println(searchInsert3(A, target));
	}

}
