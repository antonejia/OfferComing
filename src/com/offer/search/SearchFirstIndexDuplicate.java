package com.offer.search;

import javax.xml.stream.events.EndDocument;

/**
 * 有道面试题：
 * 一个数组只有一个重复元素，并且非重复元素之间仅相隔1，找出重复元素的起始位置
 * 例如数组：1,2,3,3,3,4,5 输出2（3的起始位置）
 * 
 * 此题写法与普通二分的区别在 1,2,3处
 * @author bupt
 *
 */
public class SearchFirstIndexDuplicate {

	public static int searchFirst(int[] a){
		if (a == null || a.length == 0)
			return -1;
		
		int s = 0, e = a.length-1, mid, target;
		while (s < e-1){//1，普通二分这里写 s <= e
			target = (a[s] + a[s]+e-s)/2;
			mid = (s + e)/2;
			if (a[mid] < target){ //在左边
				e = mid;	//2，普通二分这里写  e = mid-1
			}else if (a[mid] == target){//在右边，不可能有a[mid] > target
				s = mid;	//3，普通二分这里写 s = mid+1
			}
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,2,3,4,5};
		
		System.out.println(searchFirst(a));
	}

}
