package com.offer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 二叉查找树 转 有序双向链表
 * 思路：保存中序遍历时的上一个节点，中序遍历到当前节点时，将当前节点与上一节点连成双向链表即可
 * @author bupt
 *
 */
public class BStreeToBList {

	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> l = new ArrayList<Integer>();
		if (root == null)
			return l;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		stack.push(p);
		p = p.left;
		TreeNode prev = null;
		while (p != null || !stack.isEmpty()){
			if (p != null){
				stack.push(p);
				p = p.left;
			}else {
				p = stack.pop();
				if (prev == null)//遍历到第一个节点，prev设为p
					prev = p;
				else{//否则，连接p和prev，prev++；此时并没有改变p的右节点，所以中序遍历不会断链
					p.left = prev;
					prev.right = p;
					prev = p;
				}
				//l.add(p.val);
				p = p.right;
			}
		}
		return l;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.left = n2;
		root.right = n3;
		n3.left = n4;
		n4.right = n5;*/
		TreeNode root = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n6 = new TreeNode(6);
		TreeNode n10 = new TreeNode(10);
		root.left = n2;
		root.right = n8;
		n2.left = n1;
		n2.right = n4;
		n8.left = n6;
		n8.right = n10;
		
		inorderTraversal(root);
		for (TreeNode p = n1; p != null; p = p.right){
			System.out.println(p.val);
		}
		for (TreeNode p = n10; p != null; p = p.left){
			System.out.println(p.val);
		}
		System.out.println(n1.left);
		System.out.println(n10.right);
	}

}
