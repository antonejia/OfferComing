package com.offer.BFSDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/n-queens-ii/
 * 不用输出解，只需输出解的总个数
 * @author bupt
 *
 */
public class NQueens2 {

	public int totalNQueens(int n){
		List<Integer> count = new ArrayList<Integer>();
		count.add(0);//count[0]是最后的计数
		
		helper(0, n, new int[n], count);
		
		return count.get(0);
	}
	/**
	 * 注意List<Integer> count的用法，不能直接用int count
	 * 因为后面递归传递参数时，int的话是作为局部变量传进去的，递归返回后count值不会改变
	 * 传list的话是传引用，引用的值变，递归后也变
	 * @param curRow
	 * @param n
	 * @param columnForRow
	 * @param count
	 */
	public  void helper(int curRow, int n, int[] columnForRow, List<Integer> count){
		if (curRow == n){
			count.set(0, count.get(0)+1);
			return ;
		}
		
		for (int i = 0; i < n; i++){
			columnForRow[curRow] = i;
			if (check(curRow, columnForRow)){
				 helper(curRow+1, n, columnForRow, count);
			}
		}
		
	}
	
	public  boolean check(int curRow, int[] columnForRow){
		boolean flag = true;
		
		for (int i = 0; i < curRow; i++){
			if (columnForRow[i] == columnForRow[curRow]
					|| Math.abs(curRow-i) == Math.abs(columnForRow[curRow]-columnForRow[i])){
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens2 nQueens2 = new NQueens2();
		
		System.out.println(nQueens2.totalNQueens(2));
	}

}
