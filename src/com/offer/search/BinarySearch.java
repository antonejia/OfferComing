package com.offer.search;
/**
 * 二分查找
 * @author bupt
 *
 */
public class BinarySearch {
	
	public static int binarySearch(int[] a, int t){
		if (a == null || a.length == 0){
			return -1;
		}
		int start = 0, end = a.length-1, mid;
		while(start <= end){
			//mid = (start + end) / 2;
			mid = start + ((end - start) >> 1);//这样写可防止start+end溢出，同时移位运算也更高效
			/*if (t == a[mid]){
				return mid;
			}else if(t > a[mid]){
				start = mid + 1;
			}else {
				end = mid - 1;
			}*/
			if (t > a[mid]){
				start = mid + 1;
			}else if(t < a[mid]){
				end = mid - 1;
			}else {
				return mid;
			}
	        //可能会有读者认为刚开始时就要判断相等，但毕竟数组中不相等的情况更多
	        //如果每次循环都判断一下是否相等，将耗费时间
		}
		return -1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,4,8,9,13,18,20,34,39};
		System.out.println(binarySearch(a, 13));
	}

}
