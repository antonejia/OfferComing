package com.offer.string;
/**
 * http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 * 最长回文子串
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * @author bupt
 *
 */
public class LongestPalindrome {

	//这是我的写法，缺点：i，j等区间判断问题非常复杂，容易混乱
	public static String longestPalindrome(String s){
		if (s == null || s.length() == 0){
			return null;
		}
		int len = s.length();
		int maxLen = 0;
		String longestPalin = null;
		for (int i = 0; i < len; ++i){
			if (i+1<len && s.charAt(i) == s.charAt(i+1)){
			//偶数
				int j = 0;
				while (i-j >= 0 && i+1+j < len
						&& s.charAt(i-j) == s.charAt(i+1+j)){
					j++;
				}
				if (j*2 > maxLen){
					longestPalin = s.substring(i-j+1, i+1+j);
					maxLen = j*2;
				}
			}
			//奇数
			int j = 1;
			while (i-j >= 0 
					&& i+j < len
					&& s.charAt(i-j) == s.charAt(i+j)){
				j++;
			}
			if ((j-1)*2+1 > maxLen){
				longestPalin = s.substring(i-(j-1), i+(j-1)+1);
				maxLen = (j-1)*2+1;
			}
		}
		
		return longestPalin;
	}
	
	public static String longestPalindrome2(String s){
		if (s == null || s.isEmpty())
			return null;
		if (s.length() == 1)
			return s;
			
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); ++i){
			//以 i 为中心，获取最长子串
			String sub = helper(s, i, i);
			if (sub.length() > longest.length()){
				longest = sub;
			}
			//以(i,i+1)为中心，获取最长子串
			sub = helper(s, i, i+1);
			if (sub.length() > longest.length()){
				longest = sub;
			}
		}
		
		return longest;
	}
	
	public static String helper(String s, int begin, int end){
		while(begin >=0 && end <s.length() && s.charAt(begin) == s.charAt(end)){
			begin--;
			end++;
		}
		
		return s.substring(begin+1, end);
	}
	/**
	 * 动态规划求解
	 * @param s
	 * @return
	 */
	public static String longestPalindrome3(String s){
		if (s == null || s.length() == 0)
			return null;
		if (s.length() == 1)
			return s;
		int n = s.length();
		int[][] a = new int[n][n];
		int longest = 1;
		int start = 0;
		//i遍历行
		for (int i = 0; i < n; ++i){
			a[i][i] = 1;
			if (i+1 < n){
				a[i][i+1] = s.charAt(i) == s.charAt(i+1)? 1:0;
				if (a[i][i+1] == 1){
					longest = 2;
					start = i;
				}
			}
		}
		
		for (int m = 2; m < n; m++){
			for (int i = 0; i < n-m; i++){
				a[i][i+m] = s.charAt(i) == s.charAt(i+m) ? a[i+1][i+m-1] : 0;
				if (a[i][i+m] == 1){
					longest = m+1;
					start = i;
				}
			}
		}
		
		return s.substring(start, start+longest);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdcbe";
		System.out.println(longestPalindrome2(s));
		System.out.println(longestPalindrome3(s));
		
		System.out.println(s.isEmpty());

	}

}
