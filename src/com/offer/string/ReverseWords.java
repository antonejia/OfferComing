package com.offer.string;

import java.util.LinkedList;
import java.util.Scanner;

/**

	Given an input string, reverse the string word by word.
	
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
	
	click to show clarification.
	
	Clarification:
	1、What constitutes a word?
		A sequence of non-space characters constitutes a word.
	2、Could the input string contain leading or trailing spaces?
		Yes. However, your reversed string should not contain leading or trailing spaces.
	3、How about multiple spaces between two words?
		Reduce them to a single space in the reversed string.

Time: 2014.05.06
 */
public class ReverseWords {
	public static void main(String[] args){
		ReverseWords reverseWords = new ReverseWords();
		/*Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\r\\n");
		while (scanner.hasNext()){
			String string = scanner.next();
			reverseWords.reverseWords(string);
		}*/
		String s = "";
		reverseWords.reverseWords(s);
	}
	public  String reverseWords(String s) {
		if (s == null){
			return null;
		}
		s = s.trim();
		if ("".equals(s)){
			return "";
		}
        StringBuffer sentense = new StringBuffer();
        String[] words = s.split(" +");
        for (int i = words.length-1; i > 0; --i){
        	sentense.append(words[i]+" ");
        }
        sentense.append(words[0]);
		
        return sentense.toString();
    }
}
