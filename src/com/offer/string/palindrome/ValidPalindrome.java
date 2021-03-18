package com.offer.string.palindrome;

public class ValidPalindrome {

	public static boolean isPalindrome(String s){
		if (s == null || s.isEmpty())
			return true;
		int i = 0, j = s.length()-1;
		
		while(i < j){
			while (i < j && !validChar(s.charAt(i))) 
				i++;
			while (i < j && !validChar(s.charAt(j))) 
				j--;
			if (i < j && toLower(s.charAt(i)) == toLower(s.charAt(j))){
				i++;
				j--;
			}else {
				break;
			}
		}

		if (i >= j)
			return true;
		
		return false;
	}
	
	public static boolean validChar(char ch){
		if ((ch >='0' && ch <='9') || (ch >='a' && ch <='z') || (ch >='A' && ch <='Z'))
			return true;
		return false;
	}
	
	public static int toLower(char ch){
		if (ch>='A' && ch<='Z'){
			return 'a'+(ch-'A');
		}
		
		return ch;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1a2";
		System.out.println(isPalindrome(s));
		
	}

}
