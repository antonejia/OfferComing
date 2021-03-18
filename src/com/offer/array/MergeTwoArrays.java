package com.offer.array;
/**
 * http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
 * 这个问题与普通合并两个有序链表不同，因为需要合并在 A 数组中，并且认为A的长度足够长(> m+n)
 * 所以，就有更为高效的方法，空间复杂度低
 * @author bupt
 *
 */
public class MergeTwoArrays {

	public static void mergeTwoArrays1(int[] a, int m, int[] b, int n){
		while (m > 0 && n > 0){
			if (a[m-1] > b[n-1]){
				a[m+n-1] = a[m-1];
				m--;
			}else {
				a[m+n-1]= b[n-1];
				n--;
			}
		}
		while (n > 0){
			a[m+n-1] = b[n-1];
			n--;
		}
		//不需要while(m>0){}了，因为当 n 已经到了头后，m即使没到头，a[0, m]就不需要动了，已经是在正确的位置
	}
	
	public static void mergeTwoArrays2(int[] a, int m, int[] b, int n){
		int i = m-1, j = n-1;
		int k = m+n-1;
		while(k >= 0 && j >= 0){ //j < 0后就不用再执行了
			if (i >= 0 && a[i] > b[j]){ //i<0后还得执行else，将b剩下的合并
				a[k--] = a[i--];
			}else {
				a[k--] = b[j--];
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = {1,4,5,10,15};
		int[] n = {3,7,8,11,16};
	}

}
