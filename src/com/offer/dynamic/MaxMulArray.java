package com.offer.dynamic;
/**
 * 题目描述
	给一个浮点数序列，取最大乘积连续子串的值，例如 -2.5，4，0，3，0.5，8，-1，则取出的最大乘积连续子串为3，0.5，8。
	也就是说，上述数组中，3 0.5 8这3个数的乘积3*0.5*8=12是最大的，而且是连续的。
	https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/05.01.md
 * @author bupt
 *
 */
public class MaxMulArray {

	
	/**
	 * 这是我的做法，是错误的
	 * 例如：double[] a = {-2.5, 4, -2.5, 3, 0.5, 8, -1};
	 * 这时输出结果错误，因为对于a[2],currentMul算成了-2.5,应该是-2.5 * 4 * -2.5 = 25
	 * 原因在于，没有考虑当前数为负值，当前数之前的最小乘积（可能会负数）的情况，这样负负得正，
	 * @param a
	 * @return
	 */
	public static double maxMulArray(double [] a){
		double currentMul = 1, maxMul = 1;
		int currentStart = 0, currentEnd = 0, maxStart = 0, maxEnd = 0;
		for (int i = 0; i  < a.length; ++i){
			if (currentMul * a[i] > 1){
				currentMul *= a[i];
				currentEnd = i;
			}else{
				currentMul = a[i];
				currentStart = i;
				currentEnd = i;
			}
			
			if (currentMul > maxMul){
				maxMul = currentMul;
				maxStart = currentStart;
				maxEnd = currentEnd;
			}
		}
		System.out.println("maxStart = "+ maxStart + "; maxEnd = " + maxEnd);
		return maxMul;
	}
	/**
	 * 考虑到乘积子序列中有正有负也还可能有0，我们可以把问题简化成这样：数组中找一个子序列，使得它的乘积最大；同时找一个子序列，使得它的乘积最小（负数的情况）。
	 * 因为虽然我们只要一个最大积，但由于负数的存在，我们同时找这两个乘积做起来反而方便。也就是说，不但记录最大乘积，也要记录最小乘积。
	 * 假设数组为a[]，直接利用动态规划来求解，考虑到可能存在负数的情况，我们用maxend来表示以a[i]结尾的最大连续子串的乘积值，用minend表示以a[i]结尾的最小的子串的乘积值，
	 * 那么状态转移方程为：
	 * maxend = max(max(maxend * a[i], minend * a[i]), a[i]);
	 * minend = min(min(maxend * a[i], minend * a[i]), a[i]); 
	 * 初始状态为maxend = minend = a[0]。
	 */
	public static double MaxProductSubstring(double[] a){
	    double curMax = a[0];
	    double curMin = a[0];
	    double maxResult = a[0];
	    int curMaxStart = 0, curMaxEnd = 0, curMinStart = 0, curMinEnd = 0, maxStart = 0, maxEnd = 0;
	    for (int i = 1; i < a.length; ++i){
	        int tmp1 = curMaxStart, tmp2 = curMinStart;
	    	double end1 = curMax * a[i], end2 = curMin * a[i];
	        curMax = Math.max(Math.max(end1, end2), a[i]);
	        if (curMax == end1){
	        	curMaxEnd = i;
	        }else if (curMax == end2){
	        	curMaxStart = curMinStart;
	        	curMaxEnd = i;
	        }else {
				curMaxStart = i;//
				curMaxEnd = i;//
			}
	        curMin = Math.min(Math.min(end1, end2), a[i]);
	        if (curMin == end1){
	        	curMinStart = tmp1;
	        	curMinEnd = i;
	        }else if (curMin == end2){
	        	curMinEnd = i;
	        }else {
	        	curMinStart = i;
	        	curMinEnd = i;
			}
	        maxResult = Math.max(maxResult, curMax);
	        if (maxResult == curMax){
	        	maxStart = curMaxStart;//
	        	maxEnd = curMaxEnd;//
	        }
	    }
	    System.out.println("maxStart = "+ maxStart + "; maxEnd = " + maxEnd);
	    return maxResult;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {-2.5, 4, -1, 3, 0.5, 8, -1};
		System.out.println(maxMulArray(a));
		System.out.println(MaxProductSubstring(a));
		
	}

}
