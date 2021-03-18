package com.offer.dynamic;

public class UniqueBST {

	public static int numTrees(int n){
		int[] r = new int[n+1];
		r[0] = r[1] = 1;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		for (int i = 2; i <= n; i++){
			for (int k = i-1; k >= 0; k--){
				r[i] += r[k]*r[i-1-k];
			}
		}
		
		return r[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
