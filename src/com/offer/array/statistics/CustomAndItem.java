package com.offer.array.statistics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by bupt on 2014/10/9.
 * http://blog.chinaunix.net/uid-26750075-id-3370694.html
 * Question:
 We have an array representing customer’s shopping records.
 For example, it’s an array like this:
 custA, item1,
 custB, item1,
 custA, item2,
 custB, item3,
 custC, item1,
 custC, item3,
 custD, item2,
 This array indicates that customer A bought item 1, customer B bought item 1, customer A bought item 2, customer B bought
 item 3, etc..
 For a given item X and shopping records array, write code to find out what else (item Y) was bought mostly by the customers
 who bought item X.
 For example, in above example, if X is item 1 then Y should be item 3.
 Rules:
 1.  One customer can only buy one item once.
 2.  The mostly brought item should not be item X.
 3.  If no customer brought item X, then return “None”
 4.  If all the customers who brought item X only brought item X, then return “None”
 5.  The first line of input is the item X. The second line of input is the shopping record array, this shopping record array is
 split by space.
 6.  If there are many other mostly brought items which have equally brought times, then return any one of those items.
 Examples:
 Input1:
 item1
 custA item1 custB item1 custA item2 custB item3 custC item1 custC item3 custD item2
 Output1:
 item3

 Input2:
 item2
 custA item1 custB item1 custC item1 custA item2 custB item3 custA item3
 Output2:
 item1
 (The output2 can be item3 too)
 */
public class CustomAndItem {

    public static String helper(String itemX, String recordString){
        String[] records = recordString.split(" ");
        int n = records.length;
        HashSet<String> custs = new HashSet<String>();
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        String maxItem = "None";
        int maxCount = 0;

        for (int i = 1; i < n; i += 2){
            if (records[i].equals(itemX)){
                custs.add(records[i-1]);
            }
        }
        for (int i = 0 ; i < n-1; i += 2){
            if (custs.contains(records[i]) && !records[i+1].equals(itemX)){
                if (countMap.containsKey(records[i+1])){
                    countMap.put(records[i+1], countMap.get(records[i+1])+1);
                }else{
                    countMap.put(records[i+1], 1);
                }
                if (countMap.get(records[i+1]) >= maxCount){
                    maxItem = records[i+1];
                    maxCount = countMap.get(records[i+1]);
                }
            }
        }
        System.out.println(custs);
        System.out.println(countMap);
        System.out.println(maxCount);
        return maxItem;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String itemX = null, records = null;
        if (scanner.hasNext()){
            itemX = scanner.next();
        }
        if (scanner.hasNext()) {
            records = scanner.next();
        }
        System.out.println(itemX);
        System.out.println(records);
        System.out.println(helper(itemX, records));
    }
}
