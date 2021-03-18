package com.offer.dynamic;

public class LongestCommonString {
	/**
	 * http://blog.iderzheng.com/longest-common-substring-problem-optimization/
	 * r[i, j]表示以s[i]和s[j]为结尾的相同子串的最大长度
	 * @param s
	 * @param t
	 * @return
	 */
	public static int longestCommonString(String s, String t){
		if (s == null || t == null)
			return 0;
		int longest = 0;
		int m = s.length(), n = t.length();
		char[] sChars = s.toCharArray(), tChars = t.toCharArray();
		int[][] r = new int[m+1][n+1];
		for (int i = 1; i < m+1; i++){
			for (int j = 1; j < n+1; j++){
				r[i][j] = (sChars[i-1] == tChars[j-1]) ? (r[i-1][j-1]+1) : 0;
				longest = Math.max(longest, r[i][j]);
			}
		}
		
		return longest;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acbac";
		String t = "acaccbabb";
		System.out.println(longestCommonString(s, t));
	}

}
