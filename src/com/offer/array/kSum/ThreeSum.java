package com.offer.array.kSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ThreeSum {
	/**
	 * 递归，贪心法求解
	 * @param num
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] num){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		helper(0, 3, stack, num, 0, set);
		
		Iterator it = set.iterator();
		while (it.hasNext()){
			list.add((List<Integer>)it.next());
		}
		
		return list;
	}
	/**
	 * @param sum 当前和
	 * @param n 要找的数的个数
	 * @param s 栈存放遍历过程中的元素
	 * @param num 初始数组
	 * @param start 迭代指针
	 * @param set
	 */
	public static void helper(int sum, int n, Stack<Integer> s, int[] num, int start, Set<List<Integer>> set){
		if (s.size() == 3 && sum == 0){//栈满，并且当前sum为0表示已找到合适的元素
			System.out.println(s);
			List<Integer> l = new ArrayList<Integer>(s);
			Collections.sort(l);
			set.add(l);
			return ;
		}
		if (start < num.length){
			s.push(num[start]); //放当前元素
			helper(sum-num[start], n-1, s, num, start+1, set); //sum减当前值, start++
			s.pop(); //不放当前元素
			helper(sum, n, s, num, start+1, set);
		}
	}
	
	/**
	 * 不采用贪心算法
	 * 而是循环利用twoSum求解
	 * @param num
	 * @return
	 */
	public static List<List<Integer>> threeSum2(int[] num){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(num == null || num.length <=2)
			return list;
		
		//先排序
		Arrays.sort(num);
		
		for (int i = num.length-1; i >=2 ; i--){
			if (i < num.length-1 && num[i] == num[i+1])//防重, 如果num[i] == num[i+1]，在遍历num[i+1]时，已经找出这些元素了
				continue;
			
			List<List<Integer>> l = twoSum2(num, i-1, 0-num[i]);
			for (List<Integer> t : l){//这里直接填上num[i],因为数组有序
				t.add(num[i]);
			}
			list.addAll(l);
		}
		
		return list;
	}
	//夹逼法求所有非重复序列
	public static List<List<Integer>> twoSum2(int[] numbers, int end, int target){
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if (numbers == null || end < 1)
			return l;
		
		for (int m = 0, n = end; m < n;){
			if (numbers[m] + numbers[n] == target){
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(numbers[m]);
				t.add(numbers[n]);
				l.add(t);
				m++;
				while (m<n && numbers[m] == numbers[m-1]) m++; //防重
				n--;
				while (m<n && numbers[n] == numbers[n+1]) n--;//防重
			}else if (numbers[m] + numbers[n] < target){
				m++;
			}else {
				n--;
			}
		}
		
		return l;
	}
	
	public static void main(String[] args){
		int[] num = {6,-5,-6,-1,-2,8,-1,4,-10,-8,-10,-2,-4,-1,-8,-2,8,9,-5,-2,-8,-9,-3,-5};
		System.out.println(threeSum(num));
		System.out.println(threeSum2(num));
	}

}
