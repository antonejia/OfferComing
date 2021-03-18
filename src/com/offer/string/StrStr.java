package com.offer.string;

public class StrStr {

	public static String strStr(String haystack, String needle){
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return null;
		
		int la = haystack.length();
		int lb = needle.length();
		for (int i = 0; i <= la-lb; i++){
			int j;
			for (j = i; j < i+lb; ){
				if (needle.charAt(j-i) == haystack.charAt(j))
					j++;
				else {
					break;
				}
			}
			if(j == i+lb)
				return haystack.substring(i);
		}
		
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
