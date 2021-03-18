package com.offer.string;
/**
 * 待字闺中（09.18）
 * http://mp.weixin.qq.com/s?__biz=MjM5ODIzNDQ3Mw==&mid=200437914&idx=1&sn=c69d73c76291562856f8221ecc491ac4#rd
 *  原题
	删除字符串中的“b”和“ac”，需要满足如下的条件：
	字符串只能遍历一次
	不能够使用额外的空间
	
	例如：
	acbac ==> ""
	aaac ==> aa
	ababac ==> aa
	bbbbd ==> d
	
	进一步思考：如何处理aaccac呢，需要做哪些改变呢？
 * @author bupt
 *
 */
public class DeleteParticularChars {

	/**
	 * 考虑一个简单情况，假设值删除单个字符，如删除字符串中所有的b
	 * 思路：两个指针i和j，i遍历整个字符串，j记录不是要删除的字符串的最后位置(结果字符串的最后位置)，
	 * 如果s[i] == 'b', i++，否则，拷贝s[i]到s[j]，i++,j++
	 */
	public static String deleteParticularChar(String s, char ch){
		if (s == null || s.length() == 0)
			return s;
		int i = 0 , j = 0;
		char[] sChars = s.toCharArray();
		
		for (i = 0; i < sChars.length; i++){
			if(sChars[i] != ch){
				sChars[j] = sChars[i];
				j++;
			}
		}
		
		return new String(sChars, 0, j);
	}
	
	/**
	 * 删除ac 和  b
	 * @param s
	 */
	public static String deleteParticularChars(String s){
		if (s == null || s.length() == 0)
			return s;
		int i = 0 , j = 0;
		char[] sChars = s.toCharArray();
		boolean prevIsA = false;//记录当前字符的上一字符是否为a，初始状态显然为false
		for (i = 0; i < s.length(); i++){
			if (!prevIsA ){
				if(sChars[i] != 'a' && sChars[i] != 'b'){
					//拷贝
					sChars[j] = sChars[i];
					j++;
				}else if(sChars[i] == 'a'){
					//
					prevIsA = true;
				}
				
			}else {//前一个字符不是a
				if(sChars[i] != 'c'){
					sChars[j++] = 'a';//先拷贝上一个a
					
					if (sChars[i] != 'a' && sChars[i] != 'b'){//当前非a非b
						sChars[j++] = sChars[i];
					}
						
				}else {
					//为ac，什么都不做，i++继续遍历
				}
				prevIsA = (sChars[i] == 'a') ? true : false;
			}
			//考虑abc的情况，删除b后，ac也要删除
			if(j > 1 && sChars[j-1] == 'c' && sChars[j-2] == 'a')
				j = j-2;
		}
		//如果最后一个字符为a，上面的程序没有拷贝ta，现在添上它
		if (prevIsA){
			sChars[j++] = 'a';
		}
		
		return new String(sChars, 0, j);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcacbace";
		System.out.println(deleteParticularChars(s));
		
	}
	

}
