package com.offer.search;
/**
 * 出现次数超过一半的数字
 * 题目描述
 * 题目：数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/04.03.md
 * @author bupt
 *
 */
public class FindOneNumber {

	/**
	 * 方法1：不同的数相互抵消，最后剩下的一个就是要找的数
	 * @param a
	 * @return
	 */
	public static int findOneNumber1(int[] a){
		if (a == null || a.length == 0){
			return 0;
		}
		int rtn = 0, count = 0;
		for (int i = 0; i < a.length; ++i){
			if (count == 0){
				rtn = a[i];
				count++;
			}else{
				if (a[i] == rtn){
					count++;
				}else{
					count--;
				}
			}
		}
		
		return rtn;
	}
	
	
	
	/**
	 * 方法2：快排一次划分的思想
	 * 排序后位于中间位置的数 即 是要找的数，所以只要找出位于中间位置的数即是
	 * 
	 * 在从 start到end的a的子数组中，寻找最终划分位置为k的元素
	 * @param a
	 * @param k 
	 * @return
	 */
	public static void findOneNumber2(int[] a, int k, int start, int end){
		if (a == null || a.length == 0){
			return ;
		}
		int privot = privot(a, start, end);
		System.out.println("privot = "+privot);
		if (privot == k){
			System.out.println(a[privot]);
		}else if (privot < k){
			findOneNumber2(a, k, privot + 1, end);
		}else {
			findOneNumber2(a, k, start, privot-1);
		}
		
	}
	
	public static int privot(int[] a, int start, int end){
		int privot = a[start];
		int i = start, j = end;
		while (i < j){
			//注意要有i < j和后面的>=,不是>，这两个条件都是必须的，
			//后面的等号保证有相等元素时，i和j不会出现死循环; i < j，保证有多个相等的数时，不会越界，没有这个可能j会一直减下去
			while( i < j && a[j] >= privot ) j--; 
			a[i] = a[j];
			
			while(i < j && a[i] <= privot) i++;
			a[j] = a[i];	
			/*注意不用交换元素，减少复杂度
			 * if (i < j){
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}*/
		}
		a[i] = privot;
		return i;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,2,2,3,3,3,3};
		System.out.println(findOneNumber1(a));
		findOneNumber2(a, a.length/2, 0, a.length-1);
	}

}
