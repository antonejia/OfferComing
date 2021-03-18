package com.offer.BFSDFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static List<String> restoreIPAddresses(String s){
		List<String> list = new ArrayList<String>();
		int[] a = new int[4];//a[1], a[2],a[3]保存IP中3个点在s中的插入位置
		
		helper(1, 4, a, list, s);
		
		System.out.println(list);
		return list;
	}
	/**
	 * 
	 * @param r 第r个小数点
	 * @param n 最多n-1个，r==n时截止
	 * @param a 
	 * @param list
	 * @param s
	 */
	public static void helper(int r, int n, int[] a, List<String> list, String s){
		if (r == n){
			//找到合适的，输出
			StringBuffer sb = new StringBuffer(s);
			for (int i = 1; i < 4; i++){
				sb.insert(a[i]+i-1, ".");
			}
			list.add(sb.toString());
			return ;
		}
		
		//第r个小数点从a[r-1]+1的位置开始遍历，顶多遍历三个就可以停止了（因为IP中每个数字的位数<=3）
		for (int i = a[r-1] + 1; i <= a[r-1]+3 && i < s.length(); i++){
			a[r] = i;
			if (check(s, r, a)){
				helper(r+1, n, a, list, s);
			}
		}
	}
	/**
	 * 检查当前插入第r点后是否合法
	 * 设IP为A.B.C.D
	 * r == 1时检查A是否合法
	 * r == 2时检查B是否合法（此时A已经合法）
	 * r == 3是检查C和D是否合法（此时A和B已经合法）
	 * @param s
	 * @param r
	 * @param a
	 * @return
	 */
	public static boolean check(String s, int r, int[] a){
		boolean flag = true;
		if (r == 3){
			String tmp1 = s.substring(a[r-1], a[r]);
			String tmp2 = s.substring(a[r]);
			if (!check2(tmp1) || !check2(tmp2)){
				flag = false;
			}
		}
		else {
			String tmp = s.substring(a[r-1], a[r]);
			if (!check2(tmp)){
				flag = false;
			}
		}
		
		return flag;
	}
	
	public static boolean check2(String s){
		if (s == null || s.length()>3)
			return false;
		
		int num = Integer.valueOf(s);
		if (s.charAt(0) == '0' && s.length() > 1){
			return false;
		}
		if (num>=0 && num<=255)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "010010";
		restoreIPAddresses(s);
	}

}
