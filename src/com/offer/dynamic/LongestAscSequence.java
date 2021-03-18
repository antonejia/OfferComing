package com.offer.dynamic;

/**
 * Created by bupt on 2014/9/29.
 * http://www.acmerblog.com/dp-3-longest-increasing-subsequence-4640.html
 * 最长非降子序列的长度（非连续）
 * 如果要求解最长非降子数组（连续）的长度，要求连续，则不需要动态规划即可求解
 */
public class LongestAscSequence {
    public static int longestAscSequence(int[] a){
        if (a == null || a.length == 0)
            return 0;
        int n = a.length;
        int[] r = new int[n];
        r[0] = 1;
        int count = 1;

        for (int i = 1; i < n; i++){
            int t = 1;
            for (int j = i-1; j >= 0; j--){
                if (a[j] <= a[i]){
                    t = Math.max(t, r[j]+1);
                }
            }
            r[i] = t;
            count = Math.max(count, t);
        }

        return count;
    }

    public static int longestAscSubArray(int[] a){
        if (a == null || a.length == 0)
            return 0;
        int count = 1;
        int tCount = 1;

        for (int i = 1; i < a.length; i++){
            if (a[i] >= a[i-1])
                tCount++;
            else{
                count = Math.max(count, tCount);
                tCount = 1;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[] a = {1,4,5,7,3,5};

        System.out.println(longestAscSequence(a));
        System.out.println(longestAscSubArray(a));
    }

}
