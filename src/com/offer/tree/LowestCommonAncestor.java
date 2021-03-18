/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.offer.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author antone
 * @version $Id: LowestCommonAncestor.java, v 0.1 2020年05月29日 4:26 PM antone Exp $
 */
public class LowestCommonAncestor {

    class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();

    private static Set<Integer> visited = new HashSet<Integer>();

    public static void dfs(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }

        if(root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        if(root == null) {
            return null;
        }

        while(p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while(q != null) {
            if(visited.contains(q.val)) {
                return q;
            }

            q = parent.get(q);
        }

        return null;

    }


}