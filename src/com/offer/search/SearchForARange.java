package com.offer.search;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * 问题的关键是找到相等后，如何找左右边界，两种做法
 * 1、左右顺序查找
 * 2、左右再二分查找
 * @author bupt
 *
 */
public class SearchForARange {
	/**
	 * 我的写法
	 * 找到相等后，如何找左右边界：左右顺序查找
	 * @param A
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] A, int target){
		int[] res = {-1,-1};
		if (A == null || A.length == 0)
			return res;
		
		int start = 0, end = A.length-1, mid;
		while(start <= end){
			mid = start + ((end-start)>>1);
			if (target < A[mid]){ //在左边
				end = mid - 1;
			}else if (target > A[mid]){ //在右边
				start = mid + 1;
			}else {//相等
				int leftIndex = mid, rightIndex = mid;
				while (leftIndex >= start && A[leftIndex] == A[mid])
					leftIndex--;
				while (rightIndex <= end && A[rightIndex] == A[mid])
					rightIndex++;
				res[0] = leftIndex + 1;
				res[1] = rightIndex - 1;
				
				return res;
			}
		}
		
		return res;
	}
	/**
	 * 找到相等后，如何找左右边界：左右再二分查找
	 * @param A
	 * @param target
	 * @return
	 */
	public static int[] searchRange2(int[] A, int target){
		int[] res = {-1,-1};
		if (A == null || A.length == 0)
			return res;
		
		int start = 0, end = A.length-1, mid = 0;
		while(start <= end){
			mid = start + ((end-start)>>1);
			if (target < A[mid]){ //在左边
				end = mid - 1;
			}else if (target > A[mid]){ //在右边
				start = mid + 1;
			}else {//相等
				break;
			}
		}
		if (target != A[mid])
			return res;
		
		//相等，左右两边再二分查找
		//左边二分查找
		int newStart = start, newEnd = mid-1, newMid;
		while (newStart <= newEnd){
			newMid = (newStart+newEnd)/2;
			if (target == A[newMid])
				newEnd = newMid - 1;
			else
				newStart = newMid + 1;
		}
		res[0] = newStart;
		
		//左边二分查找
		newStart = mid + 1; newEnd = end;
		while (newStart <= newEnd){
			newMid = (newStart+newEnd)/2;
			if (target == A[newMid])
				newStart = newMid + 1;
			else
				newEnd = newMid - 1;
		}
		res[1] = newEnd;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1};
		int target = 1;
		
		System.out.println(Arrays.toString(searchRange(A, target)));
	}

}
