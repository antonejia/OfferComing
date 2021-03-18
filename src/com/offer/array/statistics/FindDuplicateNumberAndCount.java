package com.offer.array.statistics;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by bupt on 2014/10/8.
 * 给定数组A，大小为n，数组元素为1到n的数字，不过有的数字出现了多次，有的数字没有出现。
 * 请给出算法和程序，统计哪些数字没有出现，哪些数字出现了多少次。能够在O(n)的时间复杂度，O(1)的空间复杂度要求下完成么？
 */
public class FindDuplicateNumberAndCount {

    /**
     * 思路：由于数组内元素为1-n的，故可用数组下表 i 来表示 i 元素，a[i]的值能够表示两个值：数组原值和 i 出现的次数
     * 最终，数组元素a[i]为负值表示 i 出现过，根据a[i]的值可以算出次数；如果为正值表示 i 没有出现过；
     * 在遍历过程中，如果出现前面的计算覆盖了后面的值，即a[i]遍历时为负值，则需要还原出原来的值，再算
     * @param a
     */
    public static Map<Integer, Integer> find(int[] a){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (a == null)
            return map;
        int n = a.length;
        for (int i = 0; i < a.length; i++){
            int num = a[i];
            if (a[i] < 0){//恢复原值
                num = num + (-num/n+1)*n;
            }
            a[num-1] = a[num-1] - n;
        }
        //根据此时a数组的值，就可以判断哪些元素没有出现过，哪些出现了多少次
        for (int i = 0; i < n; i++){
            if (a[i] > 0){
                map.put(i+1, 0);
            }else{
                map.put(i+1, -a[i]/n+1);
            }
        }

        return map;
    }

    public static void main(String[] args){
        int[] a = {1,2,2,6,5,5};
        System.out.println(find(a));
    }
}
