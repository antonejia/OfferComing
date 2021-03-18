package com.offer.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

设状态为 f (i)，表示 s[0,i] 是否可以分词，则状态转移方程为
f(i) = any_of (f(j) && s[j + 1, i] 属于 dict); 0 <= j < i
 */
public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict){
		if (s == null || s.isEmpty()){
			return false;
		}
		boolean[] f = new boolean[s.length()+1];
		f[0] = true;
		for (int i = 1; i <= s.length(); ++i){
			for(int j = i-1; j >= 0; j--){
				if (f[j] && dict.contains(s.substring(j, i))){
					f[i] = true;
					break;
				}
			}
		}
		
		return f[s.length()];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "leetcode";
		String[] dictStrings = {"leet", "lee","code"};
		Set<String> dict = new HashSet<String>(Arrays.asList(dictStrings));
		
		System.out.println(wordBreak(string, dict));
		

	}

}
