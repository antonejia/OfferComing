package com.offer.dynamic;
/**
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.04.md
 * 题目描述:
	输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。 求所有子数组的和的最大值，要求时间复杂度为O(n)。
	例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2， 因此输出为该子数组的和18。
 * @author bupt
 *
 */
public class MaxSubArray {

	/**
	 * 方法1：O(n)遍历
	 * currentSum表示遍历到当前时的总和，当前面的currentSum<0时，不加，将a[i]赋值给currentSum，因为前面的数为负数，加上会使总和减少
	 * maxSum一直保持currentSum的最大值
	 * @param a
	 * @return
	 */
	public static int maxSubArray1(int[] a){
		if (a == null || a.length == 0){
			return 0;
		}
		int maxSum = a[0], //maxSum = a[0]时，如果a[]全部为负数，输出a的最大值；当maxSum = 0时， 如果a[]全部为负数，输出 0
			currentSum = 0;
		for (int i = 0; i < a.length; ++i){
			if (currentSum < 0 ){
				currentSum = a[i];
			}else {
				currentSum += a[i];
			}
			if (currentSum > maxSum){
				maxSum = currentSum;
			}
		}
		
		return maxSum;
	}
	/**
	 * 方法2：动态规划（方式实现与 1 类似，但是两种思想不同）
	 * 重点：找出状态转移方程
	 * currSum[i] 为前i个元素中，包含第i个元素且和最大的连续子数组，result 为已找到的子数组中和最大的。 对第i+1个元素有两种选择：
	 * 1 做为新子数组的第一个元素；
	 * 2 放入前面找到的子数组。
	 * currentSum[i + 1] = max{currentSum[i] + a[i], a[i]};
	 * maxSum = max{maxSum, currentSum};
	 * @param a
	 * @return
	 */
	public static int maxSubArray2(int[] a){
		if (a == null || a.length == 0){
			return 0;
		}
		int maxSum = 0, currentSum = 0;
		for (int i = 0; i < a.length; ++i){
			currentSum = (currentSum + a[i] > a[i]) ? currentSum + a[i] : a[i];
			maxSum = (currentSum > maxSum) ? currentSum : maxSum;
		}
		return maxSum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
		System.out.println(maxSubArray1(a));
		System.out.println(maxSubArray2(a));
	}

}
