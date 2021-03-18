 package com.offer.search;

public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target){
		if (matrix == null || matrix.length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length;
		int start = 0, end = m*n-1;
		while (start <= end){
			int mid = (start+end)/2;
			int midi = mid / n;
			int midj = mid % n;
			if (matrix[midi][midj] < target){
				start = mid+1;
			}else if (matrix[midi][midj] > target){
				end = mid-1;
			}else {
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
		                };
		System.out.println(searchMatrix(matrix, 4));
	}

}
