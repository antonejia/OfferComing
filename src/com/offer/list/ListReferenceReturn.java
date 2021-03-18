/*
 *
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
*/
package com.offer.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
 *
 * @author jiaxiao
 * @version $$Id: ListReferenceReturn.java, v 0.1 16/8/28 下午6:56 jiaxiao Exp $$
*/
public class ListReferenceReturn {

    public static void main(String[] args) {
        A a = new A();
        a.addItem("a");

        System.out.println(a.getList());
        List<String> outList = a.getList();
        outList.add("b");

        System.out.println(a.getList());
    }

}

class A {
    //hold a list
    private List<String> list;

    public List getList() {
        return Collections.unmodifiableList(list);
    }

    public void addItem(String item) {
        if(list == null) {
            list = new ArrayList<String>();
        }
        list.add(item);
    }
}
