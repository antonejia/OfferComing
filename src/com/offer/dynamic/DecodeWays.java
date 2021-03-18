package com.offer.dynamic;

public class DecodeWays {

	public static int numDecodings(String s){
		if (s == null || s.length() == 0)
			return 0;
		int[] r = new int[s.length()+1];
		r[0] = 1; 
		if (s.charAt(0)=='0')
			return 0;
		r[1] = 1;
		int num1 = 1, num2 = 1, num3 = 1;
		for (int i = 2; i < r.length; i++){
			int ch = Integer.valueOf(s.substring(i-2, i));
			if (s.charAt(i-2) == '0' && s.charAt(i-1) == '0')
				return 0;
			else if (s.charAt(i-2) == '0')
				//r[i] = r[i-2];
				num3 = num1;
			
			else if (s.charAt(i-1) == '0'){
				
				if (ch>=1&&ch<=26){
//					r[i] = r[i-2];
					num3 = num1;
				}else {
					return 0;
				}
				
			}else {
				//int ch = Integer.valueOf(s.substring(i-2, i));
				//r[i] = (ch>=1&&ch<=26) ? (r[i-1]+r[i-2]) : r[i-1];
				num3 = (ch>=1&&ch<=26) ? (num1+num2) : num2;
			}
			
			num1 = num2;
			num2 = num3;
		}
		
		return num2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "101";
		System.out.println(numDecodings(s));
	}

}
