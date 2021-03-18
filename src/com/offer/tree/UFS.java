package com.offer.tree;

/**
 * Created by bupt on 2014/10/14.
 * 并查集
 * 题目来源：
 * http://blog.csdn.net/jdplus/article/details/19496343
 * http://www.slyar.com/blog/disjoint-set.html
 * 两个操作：
 * 合并：合并两个集合，其实是将一棵树的根节点指向另一棵树的根节点
 * 查找：查找两个元素是否属于同一集合，其实是比较两个元素所属集合的根节点（两个元素的祖先节点）是否相同
 */
public class UFS {

    public static int findFather(int father[], int x){
        if (x != father[x]){
            father[x] = findFather(father, father[x]);
        }

        return father[x];
    }

    public static void union(int father[], int rank[], int x ,int y){
        x = findFather(father, x);
        y = findFather(father, y);
        if (x == y){
            return;
        }else if (rank[x] < rank[y]){
            father[x] = y;
        }else{
            if (rank[x] == rank[y])
                rank[x]++;
            father[y] = x;
        }

    }

    public static void main(String[] args){
        int m = 5, n =3;
        int[][] pair = {{1,2},{2,3},{4,5}};
        int[] father = new int[m+1];
        int[] rank = new int[m+1];

        //初始化set
        for (int i = 1; i <= m; i++){
            father[i] = i;
        }

        for (int i = 0; i < pair.length; i++){
            union(father, rank, pair[i][0], pair[i][1]);
        }

        int count = 0;
        for (int i = 1; i <= m; i++){
            if (i == father[i]){
                count++;
            }
        }

        System.out.println(count);
    }
}
