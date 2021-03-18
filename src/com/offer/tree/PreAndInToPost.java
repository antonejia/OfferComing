package com.offer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 已知前序遍历和中序遍历，求后序遍历
 * @author bupt
 *
 */
public class PreAndInToPost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pre = "GDAFEMHZ";
		String in =  "ADEFGHMZ";
		preAndInToPost(pre, in);
	}
	
	public static void preAndInToPost(String pre, String in){
		if (pre == null || in == null || pre.length() != in.length())
			return ;
		char[] preChars = pre.toCharArray();
		char[] inChars = in.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < inChars.length; i++){
			map.put(inChars[i], i);
		}
		helper(preChars, 0, pre.length()-1, inChars, 0, pre.length()-1, map);
	}
	
	public static void helper(char[] pre, int preStart, int preEnd, char[] in, int inStart, int inEnd, Map<Character, Integer> map){
		if (preStart <= preEnd){
			int index = map.get(pre[preStart]);
			helper(pre, preStart+1, preStart+index-inStart, in, inStart, index-1, map);
			helper(pre, preStart+index-inStart+1, preEnd, in, index+1, inEnd, map);
			System.out.println(in[index]);
		}
	}

}
