package com.offer.array;

public class SetMatrixZeros {

	public static void setZeros(int[][] matrix){
		int row = 1, column = 1;//存储第一行和第一列是否要变为0，row=0时第一行为0，column=0时第一列变为0
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				if (matrix[i][j] == 0){
					if (i == 0) row = 0;
					if (j == 0) column = 0;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int j = 1; j < matrix[0].length; j++){
			if (matrix[0][j] == 0){
				for (int i = 0; i < matrix.length; i++){
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < matrix.length; i++){
			if (matrix[i][0] == 0){
				for (int j = 0; j < matrix[0].length; j++){
					matrix[i][j] = 0;
				}
			}
		}
		//
		if (row == 0){
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 0;
		}
		if (column == 0){
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		setZeros(matrix);
		
		System.out.println(matrix);
	}

}
