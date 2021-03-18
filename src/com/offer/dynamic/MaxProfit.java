package com.offer.dynamic;
/**
 * http://blog.csdn.net/linhuanmars/article/details/23162793
 * @author bupt
 *
 */
public class MaxProfit {

	public int maxProfit(int[] prices){
		if (prices.length < 2)
			return 0;
		int profit = 0;
		int curMin = prices[0];
		for (int i = 1; i < prices.length; i++){
			profit = Math.max(profit, prices[i]-curMin);
			curMin = Math.min(curMin, prices[i]);
		}
		return profit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
