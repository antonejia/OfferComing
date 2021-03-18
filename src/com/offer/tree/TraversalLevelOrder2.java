package com.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraversalLevelOrder2 {

	public static List<List<Integer>> levelOrder(TreeNode root){
		LinkedList<List<Integer>> l = new LinkedList<List<Integer>>();
		if (root == null)
			return l;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count1 = 1, count2 = 0;//count1存放当前层节点数，count2存放下层节点数
		List<Integer> tmpList ;
		TreeNode tmpNode;
		
		while(!queue.isEmpty()){
			tmpList = new ArrayList<Integer>();
			while (count1 > 0){
				tmpNode = queue.poll();
				tmpList.add(tmpNode.val);
				if (tmpNode.left != null){
					queue.offer(tmpNode.left);
					count2++;
				}
				if (tmpNode.right != null){
					queue.offer(tmpNode.right);
					count2++;
				}
				count1--;
			}
			//count1 == 0,当前层已遍历完
			l.addFirst(tmpList);
			count1 = count2;
			count2 = 0;
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
		
		System.out.println(levelOrder(root));
	}

}
