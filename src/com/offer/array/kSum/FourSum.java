package com.offer.array.kSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	/**写法2：
	 * 道理跟下面一样，但是代码相当简洁
	 * http://www.programcreek.com/2013/02/leetcode-4sum-java/
	 * @param num
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum2(int[] num, int target) {
		Arrays.sort(num);
	 
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int k = j + 1;
				int l = num.length - 1;
	 
				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
	 
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);
	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
	 
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
	}
	
	public static List<List<Integer>> fourSum(int[] num, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(num == null || num.length <=3)
			return list;
		
		//先排序
		Arrays.sort(num);
		
		for (int i = num.length-1; i >=3 ; i--){
			if (i < num.length-1 && num[i] == num[i+1])//防重, 如果num[i] == num[i+1]，在遍历num[i+1]时，已经找出这些元素了
				continue;
			
			List<List<Integer>> l = threeSum2(num, i-1, target-num[i]);
			for (List<Integer> t : l){//这里直接填上num[i],因为数组有序
				t.add(num[i]);
			}
			list.addAll(l);
		}
		
		return list;
	}
	
	/**
	 * 不采用贪心算法
	 * 而是循环利用twoSum求解
	 * @param num
	 * @return
	 */
	public static List<List<Integer>> threeSum2(int[] num, int end, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(num == null || end < 2)
			return list;
		
		for (int i = end; i >=2 ; i--){
			if (i < end && num[i] == num[i+1])//防重, 如果num[i] == num[i+1]，在遍历num[i+1]时，已经找出这些元素了
				continue;
			
			List<List<Integer>> l = twoSum2(num, i-1, target-num[i]);
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,0,0,0};
//		int[] num = {1, 0, -1, 0, -2, 2};
		
		System.out.println(fourSum(num, 0));
	}

}
