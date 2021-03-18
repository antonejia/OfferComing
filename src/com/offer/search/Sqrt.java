package com.offer.search;

/**
 * Created by bupt on 2014/10/8.
 * https://oj.leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public static int sqrt(int x) {
        if (x < 0)
            return -1;
        if (x == 0)
            return 0;

        int left = 1, right = x / 2 + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //if (mid*mid <= x && (mid+1)*(mid+1) > x){ //涓嶇煡閬撹繖鏍蜂负浣曚細鍑虹幇Time Limit Exceed
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}