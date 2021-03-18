package com.offer.test;

import java.util.Scanner;

/**
 * Created by bupt on 2014/10/9.
 */
public class Test {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("\n");
        int count = 0;
        String nums = null;
        if (scanner.hasNext()){
            count = Integer.valueOf(scanner.nextLine());
        }
        if (scanner.hasNext()){
            nums = scanner.nextLine();
        }
        String[] a = nums.split(" ");
        int[] aa = new int[a.length];
        for (int i = 0 ;i < a.length; i++){
            aa[i] = Integer.valueOf(a[i]);
        }
        int p = (aa[a.length-1] - aa[0]) / count;
        for (int i = 0 ; i < count-1; i++){
            if (aa[i+1] != aa[i]+p){
                System.out.println(aa[i]+p);
                break;
            }
        }
    }
}
