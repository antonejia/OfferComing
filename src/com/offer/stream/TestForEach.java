/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.offer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author antone
 */
public class TestForEach {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> newList = new ArrayList<>();
        list.forEach(a -> {

            newList.add(a); // 这里不会报错，因为没有修改newList指针，只是增加元素

            //newList = new ArrayList<>();// 而这里会报错的
        });

        System.out.println(newList);
    }

    public static void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int sum = 0;

        list.forEach(a -> {

            // sum += a; //这里会报错的, 不能修改基本类型

        });

    }
}