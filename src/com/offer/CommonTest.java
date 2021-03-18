/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.offer;

/**
 *
 * @author antone
 * @version $Id: CommonTest.java, v 0.1 2020年04月20日 3:00 PM antone Exp $
 */
public class CommonTest {
    public static void main(String[] args) {
        String[] a = null;
        try {

            System.out.println(a[2]);
        } catch (Throwable e) {
            StackTraceElement[] ste = new StackTraceElement[2];
            ste[0] = e.getStackTrace()[0];
            ste[1] = new StackTraceElement("class", "method", "file", 0);
            e.setStackTrace(ste);
            System.out.println(e);
            System.out.println(e.getStackTrace()[1].toString());
        }
    }
}