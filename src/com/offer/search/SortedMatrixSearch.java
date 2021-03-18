package com.offer.search;
/**
 * 杨氏矩阵查找
 * 题目描述
 * 在一个m行n列二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/04.02.md
 * @author bupt
 *
 */
public class SortedMatrixSearch {
	/**
	 * 解法二：定位法
	 * @param a
	 * @param t 要找的数
	 * @return
	 */
	public static boolean sortedMatrixSearch(int[][] a, int t){
		if (a == null || a.length == 0){
			return false;
		}
		int row = a.length, col = a[0].length;
		int i = 0, j = col - 1;
		while (i < row && j >= 0){
			if (a[i][j] > t){
				j--;
			}else if (a[i][j] < t){
				i++;
			}else {
				return true;
			}
		}
		
		return false;
	}
	/** 另一种写法
	 	#define ROW 4
		#define COL 4
		
		bool YoungMatrix(int array[][COL], int searchKey){
		    int i = 0, j = COL - 1;
		    int var = array[i][j];
		    while (true){
		        if (var == searchKey)
		            return true;
		        else if (var < searchKey && i < ROW - 1)
		            var = array[++i][j];
		        else if (var > searchKey && j > 0)
		            var = array[i][--j];
		        else
		            return false;
		    }
		}
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {
		{1,4,7,11,15},
		{2,5,8,12,19},
		{3,6,9,16,22},
		{10,13,14,17,24},
		{18,21,23,26,30}
		};
		System.out.println(sortedMatrixSearch(a, 20));
	}

}
