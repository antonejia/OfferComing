package com.offer.array.kSum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] numbers, int target){
		int[] res = new int[2];
		if (numbers == null || numbers.length < 2)
			return res;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0 ;i < numbers.length; ++i){
			map.put(numbers[i], i);
		}
		
		for (int i = 0; i < numbers.length ; i++){
			int gap = target - numbers[i];
			if (map.containsKey(gap) && map.get(gap)>i){//map.get(gap)>i这个条件是必须的，考虑{3,2,4}和6，如果没有这个条件，输出1,1
				res[0] = i+1;
				res[1] = map.get(gap)+1;
				break;
			}
		}
			
		return res;
	}
	
	public static int[] twoSum2(int[] numbers, int target){
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++){
			if (map.containsKey(numbers[i])){
				res[0] = map.get(numbers[i])+1;
				res[1] = i+1;
				break;
			}else {
				map.put(target-numbers[i], i);
			}
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0,4,3,0};
		int target = 0;
		
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

}
