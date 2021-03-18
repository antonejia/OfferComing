package com.offer.BFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * 单词表的所有发音
 * 一个单词有多个发音，求所有的单词的所有可能发音
 * @author bupt
 *
 */
public class WordsAnnounce {

	public static void wordsAnnounce(Map<String, List<String>> map, List<String> keys){
		List<List<String>> r = new ArrayList<List<String>>();
		//List<String> l = new ArrayList<String>();
		
		helper(0, keys, new String[keys.size()], map, r);
		System.out.println(r);
	}
	/**
	 * 用String[] s保存一次结果，不能用list
	 * @param level
	 * @param keys
	 * @param s
	 * @param map
	 * @param r
	 */
	public static void helper(int level, List<String> keys, String[] s, Map<String, List<String>> map, List<List<String>> r){
		if (level == keys.size()){
			//找到一个，找到后将s的副本填入结果集，s后面要变化
			String[] tt = new String[s.length];
			System.arraycopy(s, 0, tt, 0, s.length);
			List<String> t = Arrays.asList(tt);
			r.add(t);
			
			return ;
		}else {
			for (int i = 0; i < map.get(keys.get(level)).size(); i++){
				s[level] =  map.get(keys.get(level)).get(i);
				helper(level+1, keys, s, map, r);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		List<String> aList = new ArrayList<String>();
		List<String> bList = new ArrayList<String>();
		List<String> cList = new ArrayList<String>();
		List<String> dList = new ArrayList<String>();
		
		aList.add("a1");aList.add("a2");
		aList.add("a3");aList.add("a4");
		
		bList.add("b1");bList.add("b2");
		
		cList.add("c1");cList.add("c2");
		
		
//		aList.add("a1");aList.add("a2");
//		aList.add("a3");aList.add("a4");
		
		map.put("a", aList);
		map.put("b", bList);
		map.put("c", cList);
		
		List<String> keys = new ArrayList<String>();
		keys.add("a");
		keys.add("b");
		wordsAnnounce(map, keys);
	}

}
