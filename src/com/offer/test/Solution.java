package com.offer.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by bupt on 2014/10/9.
 */
public class Solution {

    public static void main(String args[] ) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String n =
        System.out.println(helper("110"));
    }

    public static String helper(String n){
        if (n == null || n.length() == 0)
            return null;
        if (n.length() == 1){
            return String.valueOf(Integer.valueOf(n)+1);
        }
        int len = n.length();
        char[] nChars = n.toCharArray();
        int i = 0, j = len-1;
        for (; i < j; i++, j--){
            nChars[j] = nChars[i];
        }
        if (i == j) {
            //濂囨暟
            if (Integer.valueOf(new String(nChars)) <= Integer.valueOf(n)) {
                nChars[i] = (char) ('0' + (nChars[i] - '0') + 1);
            }
        }
        else{
            //鍋舵暟
            if (Integer.valueOf(new String(nChars)) <= Integer.valueOf(n)){
                nChars[i] = (char)('0'+(nChars[i]-'0')+1);
                nChars[j] = (char)('0'+(nChars[j]-'0')+1);
            }
        }

        return new String(nChars);
    }
}
