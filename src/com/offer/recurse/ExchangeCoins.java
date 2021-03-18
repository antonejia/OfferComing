package com.offer.recurse;
/**
 * 换硬币问题。
 *想兑换100元钱，有1,2,5,10四种钱，问总共有多少兑换方法。
 * @author bupt
 *
 */
public class ExchangeCoins {
	/**
 	 * a存储所有零钱，n存储要换的整钱，result[i]存储换取整钱 i 的方法总数
 	 * for循环解释：
 	 * 零钱只有1元时，result[i] = 1
 	 * 零钱有1、2元时，j从a[i](即2)开始遍历，因为<a[i]的数不能用a[i]来换，至少==a[i]才能用a[i]换
 	 * result[j] += result[j - a[i]]; 的意思是在原来的基础上，加上j-a[i]的种类数，因为每一个j-a[i]的换零序列最后加上a[i]，就是j新的包含a[i]的换零序列
 	 * 例如：
 	 * 零钱只有1时，序列为：1，1，1，1，1
 	 * 加入2后，          序列为：1，1，2，2，3
 	 * result[2] = 1+result[2-2] = 2
 	 * result[3] = 1+result[3-2] = 2
 	 * result[4] = 1+result[4-2] = 3
 	 * 
 	 * 这种方法并没有重复的序列出现，因为每次循环计算的时候，都是加上一个原来不存在的数，例如上面的计算，每次在换零序列中都加上2
	 */
	public static int exchangeCoins(int n, int [] a){
		int result[] = new int[n+1];
		result[0] = 1; //为了保证result[1] 为1，设置result[0] = 1 ，not 0
		
		for (int i = 0 ;i < a.length; i++){
			for (int j = a[i]; j <= n; ++j){
				result[j] += result[j - a[i]]; 
			}
		}
		
		return result[n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		int[] a = {1,2,5,10};
		System.out.println(exchangeCoins(n, a));
	}

}
