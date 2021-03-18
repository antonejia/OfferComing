package com.offer.string;

public class StringToInt2 {
	/**
	 * 我的版本1
	 * @param str
	 * @return
	 */
	public static int atoi(String str){
		if (str == null || str.length() == 0)
			return 0;
		
		str = str.trim();
		if (str.isEmpty())
			return 0;
		
		int sum = 0;
		boolean negative = false;
		boolean flag = false; //flag表示是否越界
		int i = 0;
		int border = Integer.MIN_VALUE / 10;//注意边界：为什么要除10
		if (str.charAt(0) == '-'){
			negative = true;
			i++;
		}else {
			if (str.charAt(0) == '+')
				i++;
		}
		
		while (i < str.length()){
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9'){
				break;
			}
			int cur = ch - '0';
			if ( sum < border || sum*10 < Integer.MIN_VALUE+cur){
				//越界
				flag = true;
				break;
			}
			
			sum = sum*10-cur;
			i++;
		}
		
		if (!flag && !negative){//正数的情况下，当sum=Integer.MIN_VALUE时也是越界
			if (sum == Integer.MIN_VALUE)
				flag = true;
		}
		if (flag){
			if (negative)
				return Integer.MIN_VALUE;
			else {
				return Integer.MAX_VALUE;
			}
		}
		
		if (!negative){
			sum *= -1;
		}
		
		return sum;
	}
	
	/**
	 * 我的版本2，参考jdk标准实现后的修改
	 * 注意的部分：
	 * 		如果判断越界
	 * 修改部分：
	 * 		根据正负设置不同的border，省去后面flag和negative的双重判断，来考虑（正数的情况下，当sum=Integer.MIN_VALUE时也是越界）这种情况
	 * @param str
	 * @return
	 */
	public static int atoi2(String str){
		if (str == null || str.length() == 0)
			return 0;
		
		str = str.trim();
		if (str.isEmpty())
			return 0;
		
		int sum = 0;
		boolean negative = false;
		boolean flag = false; //是否越界
		int i = 0;
		int border;
		
		if (str.charAt(0) == '-'){
			negative = true;
			border = Integer.MIN_VALUE; //负数时，设置border为Integer.MIN_VALUE
			i++;
		}else {
			if (str.charAt(0) == '+')
				i++;
			border = -Integer.MAX_VALUE; //整数时，设置border为-Integer.MAX_VALUE
		}
		
		while (i < str.length()){
			char ch = str.charAt(i);
			if (ch < '0' || ch > '9'){
				break;
			}
			int cur = ch - '0';
			if ( sum < border/10 || sum*10 < border+cur){
				//越界
				flag = true;
				break;
			}
			
			sum = sum*10-cur;
			i++;
		}
		
		if (flag){
			if (negative)
				return Integer.MIN_VALUE;
			else {
				return Integer.MAX_VALUE;
			}
		}
		
		if (!negative){
			sum *= -1; //将负数转换为正数
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "-";
		
		System.out.println(atoi(s));

	}

}
