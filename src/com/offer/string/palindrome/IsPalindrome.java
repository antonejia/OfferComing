package com.offer.string.palindrome;

/**
 * Created by bupt on 2014/10/7.
 * 判断一个整型值是否是回文串
 * 例如：12321
 * 第一次：判断收尾1,1，首部1 = 12321 / 10000; end = 12321 % 10 ; d: 10000 / 100；num: 12321 % 10000 /10
 * 第二次：                   231 / 100;            231 % 10        100 / 100
 */
public class IsPalindrome {
    public static boolean isPalindrome(long num){
        if (num < 0)
            return false;
        long d = 1;

        while (num / d != 0){
            d = d * 10;
        }
        d = d / 10;
        if (d == 1)
            return true;
        //System.out.println(d);
        while (d != 0){
            long left = num / d;
            long right = num % 10;
            if (left != right)
                return false;
            num = num % d / 10;
            d = d / 100;
        }

        return true;
    }

    public static void main(String[] args){
        long num  = 15651;
        System.out.println(isPalindrome(num));
    }
}
