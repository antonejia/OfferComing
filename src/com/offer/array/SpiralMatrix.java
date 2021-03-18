package com.offer.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix){
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0){
			return list;
		}
		int row = matrix.length, column = matrix[0].length;
		helper(list, matrix, 0, 0, row, column);
		
		return list;
	}
	public static void helper(List<Integer> list, int[][] matrix, int rIndex, int cIndex, int row, int column){
		if (row > 0 && column > 0){
			int maxRowIndex = rIndex + row;
			int maxColumnIndex = cIndex + column;
			if (row == 1){
				for (int i = cIndex; i < maxColumnIndex; i++){
					list.add(matrix[rIndex][i]);
				}
				return ;
			}else if (column == 1){
				for (int i = rIndex; i < maxRowIndex; i++){
					list.add(matrix[i][cIndex]);
				}
				return ;
			}
			
			for (int i = cIndex; i < maxColumnIndex; i++)
				list.add(matrix[rIndex][i]);
			for (int i = rIndex+1; i < maxRowIndex; i++)
				list.add(matrix[i][maxColumnIndex-1]);
			for (int i = maxColumnIndex-2; i>=cIndex; i--)
				list.add(matrix[maxRowIndex-1][i]);
			for (int i = maxRowIndex-2; i>rIndex; i--)
				list.add(matrix[i][cIndex]);
			
			helper(list, matrix, rIndex+1, cIndex+1, row-2, column-2);
		}
		
			
	}
	
	public static List<Integer> spiralOrder2(int[][] matrix){
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0){
			return list;
		}
		int row = matrix.length, column = matrix[0].length;
		int rIndex = 0, cIndex = 0;
		while (row > 0 && column >0){
			int maxRowIndex = rIndex + row;
			int maxColumnIndex = cIndex + column;
			if (row == 1){
				for (int i = cIndex; i < maxColumnIndex; i++){
					list.add(matrix[rIndex][i]);
				}
				return list;
			}else if (column == 1){
				for (int i = rIndex; i < maxRowIndex; i++){
					list.add(matrix[i][cIndex]);
				}
				return list;
			}
			
			for (int i = cIndex; i < maxColumnIndex; i++)
				list.add(matrix[rIndex][i]);
			for (int i = rIndex+1; i < maxRowIndex; i++)
				list.add(matrix[i][maxColumnIndex-1]);
			for (int i = maxColumnIndex-2; i>=cIndex; i--)
				list.add(matrix[maxRowIndex-1][i]);
			for (int i = maxRowIndex-2; i>rIndex; i--)
				list.add(matrix[i][cIndex]);
			
			rIndex = rIndex+1;
			cIndex = cIndex+1;
			row = row - 2;
			column = column - 2;
		}
		
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{2},{7},{8}

		};
		
		System.out.println(spiralOrder2(matrix));
	}

}
