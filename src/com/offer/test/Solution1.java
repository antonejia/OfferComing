package com.offer.test;

import java.util.ArrayList;
import java.util.List;


public class Solution1 {

    public static void main(String args[] ) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String n =
        System.out.println(getClosestCommonAncestor(13,10));
    }

    static int getClosestCommonAncestor(int node1, int node2) {
        if (node1 == 0 || node2 == 0)
            return 0;
        int lev1 = level(node1);
        int lev2 = level(node2);
        int trueNode1 = trueNode(node1, lev1);
        int trueNode2 = trueNode(node2, lev2);
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(node1);
        list2.add(node2);
        int i = lev1;
        while(i > 0){
            if (i%2 == 0){
                list1.add(node((trueNode1-1)/3));
            }else{
                list1.add((trueNode1-1)/3);
            }
            trueNode1 = (trueNode1-1)/3;
            i--;
        }

        int j = lev2;
        while(j > 0){
            if (j%2 == 0){
                list2.add(node((trueNode2-1)/3));
            }else{
                list2.add((trueNode2-1)/3);
            }
            trueNode2 = (trueNode2-1)/3;
            j--;
        }

        for (int m = 0, n = 0; m < list1.size() || n < list2.size(); ){
            if (list1.get(m) == list2.get(n)){
                return list1.get(m);
            }
            else if (list1.get(m) > list2.get(n)){
                m++;
            }else {
                n++;
            }
        }

        return 0;

    }
    static int level(int node){
        int lev = 1;
        int start = (int)Math.pow(3,0);
        while (start < node){
            start = start+(int)Math.pow(3,lev);
            lev++;
        }

        if (start > node)
            lev--;

        return lev;
    }

    static int trueNode(int node, int level){
        if (level % 2 == 1){
            int end = 0;
            for (int i = 0; i <= level; i++){
                end = end + (int)Math.pow(3,i);
            }
            end--;
            node = end-(node-(end+1-(int)Math.pow(3,level)));
        }

        return node;
    }

    static int node(int node){
        int level = level(node);
        if (level % 2 == 1){
            int end = 0;
            for (int i = 0; i <= level; i++){
                end = end + (int)Math.pow(3,i);
            }
            end--;
            node = end-node+(end+1-(int)Math.pow(3,level));
        }

        return node;
    }

}
