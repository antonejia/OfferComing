package com.offer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalInOrder {

	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> l = new ArrayList<Integer>();
		if (root == null)
			return l;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		stack.push(p);
		p = p.left;
		while (p != null || !stack.isEmpty()){
			if (p != null){
				stack.push(p);
				p = p.left;
			}else {
				p = stack.pop();
				l.add(p.val);
				p = p.right;
			}
		}
		return l;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.left = n2;
		root.right = n3;
		n3.left = n4;
		n4.right = n5;
		
		System.out.println(inorderTraversal(root));
	}

}
