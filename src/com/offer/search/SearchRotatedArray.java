package com.offer.search;
/**
 * http://blog.csdn.net/linhuanmars/article/details/20525681
 * @author bupt
 *
 */
public class SearchRotatedArray {

	public static int searchRotatedArray(int[] A, int target){
		if (A == null || A.length == 0)
			return -1;
		int start = 0, end = A.length-1;
		while (start <= end){
			int mid = (start+end)/2;
			if (A[mid] == target)
				return mid;
			if (A[mid] < A[end]){//说明A[mid] 到A[end]是有序的
				if (target > A[mid] && target <= A[end])//target在mid+1与end之间
					start = mid+1;
				else //target在左半边
					end = mid-1;
			}else {
				//A[start]到A[mid]是有序的
				if (target >= A[start] && target < A[mid]){
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
