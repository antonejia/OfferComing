/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.offer.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author antone
 */
public class TestConstructList {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        // error, 不能添加， Arrays.asList 构造的list是immutable的
        list.add("d");

        System.out.println(list);
    }
}