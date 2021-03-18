package com.offer.array;
/**
 * 求两个有序数组的中位数，每个有序数组都可能有重复值
 * 但是注意：中位数与是否有重复值无直接关系，简单说，都是中位数左边一半数量，右边一半数量（奇数的情况），有重复值也是如此
 * 例如：1 1 2 2 3 3 4 中位数为2：(1 1 2)(2)(3 3 4)
 * @author bupt
 *
 */
public class FindMedianSortedArrays {

	
	/**
 	该方法的核心是将原问题转变成一个寻找第k小数的问题（假设两个原序列升序排列），这样中位数实际上是第(m+n)/2小的数。
 	所以只要解决了第k小数的问题，原问题也得以解决。
 	首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。
 	这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
 	换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。
 	(证明：如果大于的话，那么B[k/2-1]也肯定大于，因为此时B[k/2-1]>A[k/2-1]，这样的话TopK肯定在A[0, k/2-1]和B[0, k/2-1]中，并且个数一定小于了K,所以不成立)
	 */
	public static double findMediaSortedArrays(int[] a, int[] b){
		int m = a.length, n = b.length;
		if ((m+n)%2 != 0){
			//总长度为奇数
			return (double)findKth(a, 0, m-1, b, 0, n-1, (m+n)/2+1);
		}else {
			//总长度为偶数
			return ( findKth(a, 0, m-1, b, 0, n-1, (m+n)/2)
					+findKth(a, 0, m-1, b, 0, n-1, (m+n)/2+1) ) / 2.0;
		}
		
	}
	
	/**
	 *在a[aStart, aEnd]和b[bStart, bEnd]中寻找第 K 大的元素
	 */
	public static int findKth(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int k){
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
		
		if (aLen > bLen){
			return findKth(b, bStart, bEnd, a, aStart, aEnd, k); //注意这里不要忘记return
		}
		if (aLen == 0){
			return b[bStart+k-1]; //Don't forget "bStart"
		}
		if (k == 1){
			return Math.min(a[aStart], b[bStart]); // not "a[0], b[0]", but "a[aStart], b[bStart]"
		}
		
		int ia = Math.min(k/2, aLen), ib = k - ia; //ia, ib 表示将k个元素分别分配到两个数组中的个数
		if (a[aStart + ia - 1] < b[bStart + ib - 1]){ //注意这里以及下面的aStart+...和bStart+..,不要忘记
			//将a[0, ia-1]全部舍弃
			return findKth(a, aStart+ia, aEnd, b, bStart, bEnd, k-ia);
		}else if (a[aStart + ia-1] > b[bStart + ib-1]){
			//将b[0, ib-1]全部舍弃
			return findKth(a, aStart, aEnd, b, bStart+ib, bEnd, ia);
		}else {
			return a[aStart + ia-1];
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,6,10,15,20};
		int[] b = {2,2,7,8,8,13,18,19};
		System.out.println(findMediaSortedArrays(a, b));

	}

}
