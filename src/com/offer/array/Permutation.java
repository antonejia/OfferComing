package com.offer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 求所有排列
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.06.md
 */
public class Permutation {

	public static List<Integer> nextPermutation(int[] s){
		int len = s.length;
		//找出chars中最右边的那个升序(s[i]<s[i+1])的位置
		int i;
		for (i = len-2; i>=0 && s[i]>s[i+1]; i--);
		
		//已到序列的最大情况（排列的最后一个）
		if (i < 0){
			return null;
		}
		
		//找出chars中大于chars[i]的最右边的数的位置
		int k;
		for (k = len-1; s[k] <= s[i]; k--);
		
		//swap(chars, i, k)
		int tmp = s[i];
		s[i] = s[k];
		s[k] = tmp;
		
		//reverse(chars, i+1, len-1)
		for (int m = i+1, n = len-1; m < n; m++, n--){
			int t = s[m];
			s[m] = s[n];
			s[n] = t;
		}
		
		List<Integer> l = new ArrayList<Integer>();
		for (int ss : s){
			l.add(ss);
		}
		return l;
		
	}
	public static List<Integer> arrayToList(int[] num){
		List<Integer> l = new ArrayList<Integer>();
		for (int n : num){
			l.add(n);
		}
		return l;
	}
	public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
		int sum = 1;
		for (int i = 1; i <= num.length; i++){
        	sum *= i;
        }
		Arrays.sort(num);
		
		l.add(arrayToList(num));
		for (int i = 1; i < sum; i++){
			List<Integer> t = nextPermutation(num);
			l.add(t);
			
			for (int j = 0; j < t.size(); j++){
				num[j] = t.get(j);
			}
		}
		
		return l;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 3};
		List<List<Integer>> l = permute(num);
		for (int i = 0; i < l.size(); i++){
			System.out.println(l.get(i));
		}
		
	}

}
