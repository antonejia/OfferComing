package com.offer.array;
/**
 * 荷兰国旗
 * 
 * 题目描述
 * 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球。
 * https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.07.md
 */
import java.util.Arrays;

public class HelanFlag {

	/**
	 * 起初：begin = 0, current = 0, end = a.length-1;
	 * current从头开始遍历
	 * begin一直指向元素 1 的第一个位置，end一直指向元素 1 的最后一个位置，这样一直调整，使得begin左边的都是0，end右边的都是2
	 * @param a
	 */
	public static void reOrderHelanFlag(int[] a){
		if (a == null || a.length == 0){
			return ;
		}
		int begin = 0, current = 0, end = a.length-1;
		while(current < end){
			if (a[current] == 0){
				swap(a, begin, current);
				begin++;
				current++;
			}
			if (a[current] == 1){
				current++;
			}
			if (a[current] == 2){
				swap(a, current, end);
				end--;
			}
		}
	}
	
	public static void swap(int[] a, int m, int n){
		int tmp;
		tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={1,1,2,0,1,2,0,2,1,0};
		reOrderHelanFlag(a);
		
		System.out.println(Arrays.toString(a));
	}

}
