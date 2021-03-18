package com.offer.array.kSum;

import java.util.Arrays;

/**
 * Created by bupt on 2014/10/8.
 * 寻找两个数，使其和最接近0（可以等于0，和可为负值）
 * 换句话说，有等于0的话输出等于0，没有等于0的话输出最接近0的
 */
public class TwoSumClosestZero {
    public static int[] twoSumClosestZero(int[] a){
        if (a == null || a.length == 1)
            return null;
        //排序
        Arrays.sort(a);

        int left = 0, right = a.length-1;
        int diff = Math.abs(a[left]+a[right]);
        int[] res = new int[2];

        while(left < right){
            if (a[left]+a[right] < 0){
                //判断是否更新diff
                if (Math.abs(a[left]+a[right]) <= diff){
                    diff = Math.abs(a[left]+a[right]);
                    res[0] = a[left];
                    res[1] = a[right];
                }
                //左指针右移
                left++;
            }else if (a[left]+a[right] > 0){
                if (Math.abs(a[left]+a[right]) <= diff){
                    diff = Math.abs(a[left]+a[right]);
                    res[0] = a[left];
                    res[1] = a[right];
                }
                right--;
            }else {
                res[0] = a[left];
                res[1] = a[right];
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] numbers = {-2, 3, 4, -7, 9, 5};

        System.out.println(Arrays.toString(twoSumClosestZero(numbers)));
    }

}
