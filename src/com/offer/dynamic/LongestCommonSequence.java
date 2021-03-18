package com.offer.dynamic;

import java.util.Arrays;

/**
 * 问题描述:
    什么是最长公共子序列呢?
    好比一个数列 S，如果分别是两个或多个已知数列的子序列，且是所有符合此条件序列中最长的，则S 称为已知序列的最长公共子序列。
    举个例子，如：有两条随机序列，如 1 3 4 5 5 ，and 2 4 5 5 7 6，则它们的最长公共子序列便是：4 5 5。
    注意最长公共子串（Longest CommonSubstring）和最长公共子序列（LongestCommon Subsequence, LCS）的区别：
    子串（Substring）是串的一个连续的部分，子序列（Subsequence）则是从不改变序列的顺序，而从序列中去掉任意的元素而获得的新序列；
    更简略地说，前者（子串）的字符的位置必须连续，后者（子序列LCS）则不必。
    比如字符串acdfg同akdfc的最长公共子串为df，而他们的最长公共子序列是adf。LCS可以使用动态规划法解决。
 * 
 * 参考：
 * 1、http://blog.csdn.net/v_july_v/article/details/6695482
 * 2、算法设计与分析教材P151
 * @author bupt
 *
 */
public class LongestCommonSequence {
	
	public static int lcs(char[] a, char[] b){
		if (a == null || a.length == 0 
			|| b == null || b.length == 0)
			return 0;
		int[][] c = new int[a.length+1][b.length+1];
		int[][] s = new int[a.length+1][b.length+1];
		for (int i = 0; i < a.length+1; ++i){
			c[i][0] = 0;
			s[i][0] = 0;
		}
		for (int j = 0; j < b.length+1; ++j){
			c[0][j] = 0;
			s[0][j] = 0;
		}
		for (int j = 1; j < b.length+1; ++j){
			for (int i = 1; i < a.length+1; ++i){
				if (a[i-1] == b[j-1]){
					c[i][j] = c[i-1][j-1] + 1;
					s[i][j] = 1; //1: 左上
				}/*else if (c[i-1][j] >= c[i][j-1]){
					c[i][j] = c[i-1][j];
					s[i][j] = 2;//上
				}else{
					c[i][j] = c[i][j-1];
					s[i][j] = 3;//左
				}*/else {
					c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
					s[i][j] = (c[i][j] == c[i][j-1]) ? 3 : 2; //2:上，3:左 
				}
				
			}
		}
		
		printCS(c);
		printCS(s);
		printLCS(s, a.length, b.length, a);
		System.out.println();
		printLCS2(c, a.length, b.length, a, b);
		
		return c[a.length][b.length];
	}
	
	public static void printCS(int[][] c){
		if (c == null)
			return ;
		for (int i = 0; i < c.length; i++){
			System.out.println(Arrays.toString(c[i]));
		}
		System.out.println();
	}
	/**
	 * 由数组 s 构造出最长公共子序列
	 * @param s
	 * @param m
	 * @param n
	 * @param a
	 */
	public static void printLCS(int[][] s , int m, int n, char[] a){
		if (m == 0 || n == 0){
			return ;
		}
		if (s[m][n] == 1){
			printLCS(s, m-1, n-1, a);
			System.out.print( a[m-1] + ", ");
		}
		if (s[m][n] == 2){
			printLCS(s, m-1, n, a);
		}
		if (s[m][n] == 3){
			printLCS(s, m, n-1, a);
		}
		
	}
	/**
	 * 由数组 c 构造出最长公共子序列
	 * @param c
	 * @param m
	 * @param n
	 * @param a
	 */
	public static void printLCS2(int[][] c, int m, int n, char[] a, char[] b){
		if (m == 0 || n == 0){
			return ;
		}
		if (a[m-1] == b[n-1]){
			printLCS2(c, m-1, n-1, a, b);
			System.out.print( a[m-1] + ", ");
		}else if (c[m-1][n] > c[m][n-1]){
			printLCS2(c, m-1, n, a, b);
		}else{
			printLCS2(c, m, n-1, a, b);
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sa = "acbac";
		String sb = "acaccbabb";
		char[] a = {'a', 'b', 'c', 'b', 'd', 'a', 'b'};
		char[] b = {'b', 'd', 'c', 'a', 'b', 'a'};
		
		System.out.println();
		System.out.println( lcs(sa.toCharArray(),sb.toCharArray()) );
	}

}
