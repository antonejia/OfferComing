/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.offer.list;

import com.sun.tools.javac.util.List;

/**
 * @author antone
 */
public class TestConstructList {

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        list.add("d");

        System.out.println(list);
    }
}