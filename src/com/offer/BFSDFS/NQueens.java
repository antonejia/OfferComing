package com.offer.BFSDFS;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 思路1：http://zhedahht.blog.163.com/blog/static/2541117420114331616329/
 * 思路2：http://blog.csdn.net/linhuanmars/article/details/20667175
 * @author bupt
 *
 */
public class NQueens {
	/**
	 * 思路1：
	 * 一个数组r保存当前数组下标为i的皇后，位于第i行，第r[i]列
	 * 所有 r 的可能情况是n!，依次判断每种情况是否符合条件（行列肯定不同了，看是否有在同一斜线上的）
	 * @param n
	 * @return
	 */
	public static List<String[]> solveNQueens(int n){
		List<String[]> l = new ArrayList<String[]>();
		if (n == 1){
			String[] s = {"Q"};
			l.add(s);
		}
		int[] r = new int[n];
		for (int i = 0; i < n; ++i)
			r[i] = i;
		
		for (int j = 2; j <= fac(n); j++){
			permutation(r);
			if (isCorrect(r)){
				
				String[] s = new String[n];
				for (int k = 0; k < n; k++){
					StringBuffer sb = new StringBuffer();
					for (int p = 0; p < n; p++){
						if (p == r[k])
							sb.append("Q");
						else {
							sb.append(".");
						}
					}
					s[k] = sb.toString();
				}
				
				l.add(s);
			}
		}
		
		
		return l;
	}
	
	/**
	 * 思路2：
	 * 递归解决子问题
	 * 深搜+剪枝
	 * @return
	 */
	public static List<String[]> solveNQueens2(int n){
		List<String[]> list = new ArrayList<String[]>();
		
		helper(0, n, new int[n], list);
		return list;
	}
	
	public static void helper(int curRow, int n, int[] columnForRow, List<String[]> list){
		
		if (curRow == n){
			//到了最后一行，根据columnForRow输出结果
			String[] s = new String[n];
			for (int k = 0; k < n; k++){
				StringBuffer sb = new StringBuffer();
				for (int p = 0; p < n; p++){
					if (p == columnForRow[k])
						sb.append("Q");
					else {
						sb.append(".");
					}
				}
				s[k] = sb.toString();
			}
			
			list.add(s);
			
			return ; //!!一定要return
		}
		
		for (int i = 0; i < n; i++){
			columnForRow[curRow] = i; //尝试将当前行（curRow）的第i列放入皇后
			if (check(curRow, columnForRow)){//检查放入皇后后是否冲突
				//不冲突,继续下一行
				helper(curRow+1, n, columnForRow, list);
			}
			//冲突，i++,尝试放入i+1列（下一列）
		}
	}
	
	//判断当前curRow放入皇后之后，和之前的行有没有冲突（curRow之后的行还没有放入皇后，所以不用检查）
	public static boolean check(int curRow, int[] columnForRow){
		boolean flag = true;
		
		for (int i = 0; i < curRow; i++){
			if (columnForRow[i] == columnForRow[curRow]//同一列
					|| Math.abs(i-curRow) == Math.abs(columnForRow[i]-columnForRow[curRow]))//同一斜线
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	
	
	public static int[] permutation(int[] a){
		//找到最右边的升序对
		int i;
		for (i = a.length-2; i >=0 && a[i] > a[i+1]; i--);
		
		if (i < 0)
			return a;
		int j;
		for (j = a.length-1; j > i && a[j] <= a[i]; j--);
		//找到最右边比a[i]大的数，交换
		int tmp = a[j];
		a[j] = a[i];
		a[i] = tmp;
		
		//反转a[i+1]到a[a.length-1]
		for (int m = i+1, n = a.length-1; m < n; m++, n--){
			tmp = a[m];
			a[m] = a[n];
			a[n] = tmp;
		}
		
		return a;
	}
	
	public static boolean isCorrect(int[] a){
		boolean flag = true;
		
		for (int i = 0; i < a.length; i++){
			for (int j = i+1; j < a.length; j++){
				if (Math.abs(i-j) == Math.abs(a[i]-a[j])){
					flag = false;
					break;
				}	
			}
			if (flag == false)
				break;
		}
		return flag;
	}
	
	public static int fac(int n){
		int fac = 1;
		for (int i = 2; i <= n; ++i){
			fac *= i;
		}
		
		return fac;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,2,3,1};
		//System.out.println(Arrays.toString(permutation(a)));
		System.out.println(Arrays.toString(solveNQueens2(1).get(0)));
	}

}
