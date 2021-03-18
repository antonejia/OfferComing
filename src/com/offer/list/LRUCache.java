package com.offer.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
			map.put(key, value);//设置新的值
			
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

/**
 * LRU问题分析：
 * 对数据的 get和set操作均算一次访问，均需要修改访问 时序
 *
 * get操作拆解：
 *  - 如果不存在key，直接返回 -1；
 *  - 如果存在key，修改访问时序，返回结果
 *
 * set操作拆解：
 *  - 如果map中已存在该key，更新其value，提升其访问时序到首部
 *  - 否则
 *    - 如果没有达到容量阈值，直接put，提升其访问时序到首部
 *    - 如果到达其容量阈值，先remove map，再remove 最久没访问的，put key to map，add key to 访问时序首部
 */

class LRU2 {

	private int capacity;

	private Map<String, String> map;

	private LinkedList<String> list;

	public LRU2(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<String, String>();

		// 使用链式链表，便于快速首位元素操作
		this.list = new LinkedList<String>();
	}

	public String get(String key) {
		if(!map.containsKey(key)) {
			return null;
		} else {
			list.remove(key);
			list.addFirst(key);

			return map.get(key);
		}
	}

	public void set(String key, String value) {
		if(map.containsKey(key)) {
			map.put(key, value);

			list.remove(key);
			list.addFirst(key);
		} else {
			if(map.size() == capacity) {
				//到达极限
				map.remove(list.getLast());
				list.removeLast();

				map.put(key, value);
				list.addFirst(key);

			} else {
				map.put(key, value);
				list.addFirst(key);
			}
		}
	}
}