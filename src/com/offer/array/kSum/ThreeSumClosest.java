package com.offer.array.kSum;

import java.util.Arrays;
/**
 * http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
 * @author bupt
 *
 */
public class ThreeSumClosest {

	public static int threeSumClosest(int[] num, int target){
		if (num == null || num.length <= 2)
			return -1;
		
		Arrays.sort(num);
		int closest = num[num.length-1]+num[num.length-2]+num[0];
		for (int i = num.length-1; i >= 2; i--){
			closest = helper(num, i-1, target, closest);
			if (closest == target)
				return closest;
		}
		
		return closest;
	}
	
	public static int helper(int[] num, int end, int target, int closest){
		int diff = Math.abs(target-closest);
		int i = 0, j = end;
		while (i < j){
			int sum = num[end+1] + num[i] + num[j];
			if (sum < target){
				if (Math.abs(sum-target) < diff){
					diff = Math.abs(sum-target);
					closest = sum;
				}
				i++;
			}else if (sum > target){
				if (Math.abs(sum-target) < diff){
					diff = Math.abs(sum-target);
					closest = sum;
				}
				j--;
			}else {
				return target;
			}
		}
		
		return closest;
	}
	
	
	public static void main(String[] args) {
		int[] num =  {-3,-2,-5,3,-4};
//		int[] num =  {0,0,0};
		int target = -1;
		
		System.out.println(threeSumClosest(num, target));

	}

}
