package com.offer.array.findANumber;
/**
http://blog.csdn.net/hackbuteer1/article/details/8484974
2、异形数（25分）
在一个长度为n的整形数组a里，除了三个数字只出现一次外，其他的数字都出现了2次。请写程序输出任意一个只出现一次的数字，程序时间和空间复杂度越小越好。
例如： a = {1,3,7,9,5,9,4,3,6,1,7}，输出4或5或6
**/
public class FindTheNumHappenOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2,4,5,6,4,2};
		find(a, a.length);
	}
	// lowbit表示的是某个数从右往左扫描第一次出现1的位置
	public static int lowbit(int x)
	{
		return x&~(x-1);
	}

	public static void find(int[] a , int n)
	{
		int i , xors;
		xors = 0;
		for(i = 0 ; i < n ; ++i)
			xors ^= a[i];
		// 三个数两两的异或后lowbit有两个相同，一个不同，可以分为两组
		int fips = 0;
		for(i = 0 ; i < n ; ++i)
			fips ^= lowbit(xors ^ a[i]);
		// 表示的是：flips=lowbit(a^b)^lowbit(a^c)^lowbit(b^c) 
		int b;    // 假设三个只出现一次的其中一个数为b
		b = 0;
		for(i = 0 ; i < n ; ++i)
		{
			if(lowbit(xors ^ a[i]) == fips)
				b ^= a[i];
		}
		// 成功找到三个数中一个数
		System.out.println(b);
	}

}
