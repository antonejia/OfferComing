package com.offer.array;

import java.util.HashMap;
import java.util.Map;
/**
 * http://blog.csdn.net/doufei_ccst/article/details/12779831
 * 通过给定的转义规则，还原HTML
 * @author bupt
 *
 */
public class HtmlParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("&quot;", "\"");
		map.put("&amp;", "&");
		map.put("&lt;", "<");
		map.put("&gt;", ">");
		
		//String string = "&lt;h1&gt;&#165;&lt;/h1&gt;";
		String string = "hhhh";
		parser(string, map);
	}
	
	public static void parser(String s, Map<String, String> map){
		int p0 = 0, p1 = 0, p2 = 0; //p0代表要解析的字符串的起始位置，这个值在动态变化；p1代表要解析字符串 & 出现的首次位置；p2代表p1之后的首个";"
		while(p0 < s.length()){
			p1 = s.indexOf("&", p0); //注意这里加p0
			if (p1 == -1){
				//没有&号，普通字符串
				System.out.print(s.substring(p0));
				return;
			}else {
				System.out.print(s.substring(p0, p1));
				
				p2 = s.indexOf(";", p0); //注意这里加p0
				if (p2 == -1){
					System.out.println("格式错误……");
					break;
				}
				String tmp = s.substring(p1, p2+1);
				if (tmp.length() > 2 && tmp.charAt(1)=='#' ){
					//Unicode字符
					System.out.print((char)Integer.parseInt(tmp.substring(2, tmp.length()-1)));
					//System.out.print((char)Integer.parseInt("165"));
				}else {
					//普通转义字符
					System.out.print(map.get(tmp));
				}
				
				p0 = p2 + 1; //p0推进
			}
		}
	}

}
