package com.offer.string;

import java.util.Arrays;

/**
 *  https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.02.md
 *  
 *  给定两个分别由字母组成的字符串A和字符串B，字符串B的长度较字符串A短。
 *  请问，如何最快地判断字符串B中所有字母是否都在字符串A里？也就是说判断字符串B是不是字符串A的真子集
 * （为了简化，姑且认为两个集合都不是空集，即字符串都不为空）。且为了简单起见，我们规定输入的字符串只包含大写英文字母。
 *	请实现函数bool StringContains(string &A,string &B)
 *	比如，如果是下面两个字符串：
 *	String 1: ABCDEFGHLMNOPQRS
 *	String 2: DCGSRQPO
 *	答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
 *	如果是下面两个字符串：
 *	String 1: ABCDEFGHLMNOPQRS
 *	String 2: DCGSRQPZ
 *	答案是false，因为字符串String2里的Z字母不在字符串String1里。
 * @author jml
 *
 */
public class StringContains {
	/**
	 * 计数比较(对a做hash)
	 * @param a
	 * @param b
	 */
	public static boolean isStringContains1(char[] a, char[] b){
		int [] charCount = new int[26];
		Arrays.fill(charCount, 0);
		System.out.println(Arrays.toString(charCount));
		for (int i = 0; i < a.length; ++i){
			charCount[a[i]-'A']++;
		}
		for (int j = 0; j < b.length; ++j){
			/*
			//b中有重复，a中只需包含一个就算 a包含b
			if (charCount[b[j]-'A'] == 0){
				return false;
			}*/
			
			//b中有重复，a中必须包含所有才算 a包含b
			if (charCount[b[j]-'A']-- == 0){
				return false;
			}
			
		}
		return true;
	}
	
	/**
	 * 对 b做hash
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isStringContains2(char[] a, char[] b){
		int [] charCount = new int[26];
		Arrays.fill(charCount, 0);
		int m = 0;
		for (int i = 0; i < b.length; ++i){
			if (charCount[b[i]-'A'] == 0){
				charCount[b[i]-'A'] = 1;
				++m;
			}
		}
		/*我的写法：a都得遍历完成
		for (int i = 0; i < a.length; ++i){
			if (charCount[a[i]-'A'] == 1){
				--m;
				charCount[a[i]-'A'] = 0;
			}
		}
		
		if (m > 0){
			return false;
		}
		return true;
		*/
		//好的写法,m == 0时就可以退出循环了
		for (int i = 0; i < a.length && m > 0; ++i){
			if (charCount[a[i]-'A'] == 1){
				--m;
				charCount[a[i]-'A'] = 0;
			}
		}
		
		return m == 0;
	}
	
	/**
	 * 位运算
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isStringContains3(char[] a, char[] b){
		int hashA = 0;
		for (int i = 0; i < a.length; ++i){
			hashA |= (1 << a[i]-'A');
		}
		for (int i = 0; i < b.length; ++i){
			if (((1 << b[i]-'A') & hashA) == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBrother(char[] a, char[] b){
		if (a.length != b.length){
			return false;
		}
		int [] charCount = new int[26];
		Arrays.fill(charCount, 0);
		//int m = 0;
		for (int i = 0; i < a.length; ++i){
			/*if (charCount[a[i]-'A'] == 0){
				charCount[a[i]-'A'] = 1;
				//++m;
			}*/
			charCount[a[i]-'A']++;
		}
		for (int i = 0; i < b.length; ++i){
			if (charCount[b[i]-'A'] == 0){
				return false;
			}
			charCount[b[i]-'A']--;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String a = "ABCDEFGHLMNPQRS";
		String b = "DCGSRQPO";*/
		String a = "ABCDA";
		String b = "BCDAD";
		
		System.out.println(isBrother(a.toCharArray(), b.toCharArray()));
	}

}
