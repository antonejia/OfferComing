package com.offer.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private int capacity;
	private Map<Integer, Integer> map;
	private LinkedList<Integer> list;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<Integer, Integer>();
		list = new LinkedList<Integer>();
	}
	
	public int get(int key){
		if (!map.containsKey(key)){
			return -1;
		}else {
			list.remove(new Integer(key));//不能使list.remove(key),否则被认为key是list的index
			list.addFirst(key);
			
			return map.get(key);
		}
	}
	
	public void set(int key, int value){
		if (map.containsKey(key)){
			map.put(key, value);
			
			list.remove(new Integer(key));
			list.addFirst(key);
		}else {
			if (map.size() < capacity){
				//直接插入
				map.put(key, value);
				//更新list
				list.addFirst(key);
			}else {
				//先踢再插
				map.remove(list.getLast());
				map.put(key, value);
				
				list.removeLast();
				list.addFirst(key);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		

	}

}
