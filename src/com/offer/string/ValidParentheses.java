package com.offer.string;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s){
		if (s == null || s.isEmpty())
			return false;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		
		int i = 1;
		while(i < s.length()){
			char ch = s.charAt(i);
			if (ch == ')' || ch == ']' || ch == '}'){
				if (!stack.isEmpty() && map.get(ch) == stack.peek())
					stack.pop();
				else {
					return false;
				}
			}else {
				stack.push(ch);
			}
			i++;
		}
		
		if (!stack.isEmpty())
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		String s = "()}[]";
		
		System.out.println(isValid(s));

	}

}
