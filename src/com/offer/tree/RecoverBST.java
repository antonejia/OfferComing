package com.offer.tree;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {

	public void recoverTree(TreeNode root){
		if (root == null || (root.left == null && root.right == null))
			return ;
		List<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(null);
		List<TreeNode> res = new ArrayList<TreeNode>();
		helper(root, pre, res);
		
		if (res.size() > 0){
			int tmp = res.get(0).val;
			res.get(0).val = res.get(1).val;
			res.get(1).val = tmp;
		}
	}
	
	public void helper(TreeNode root, List<TreeNode> pre, List<TreeNode> res){
		if (root == null)
			return ;
		
		helper(root.left, pre, res);
		if (pre.get(0) != null && pre.get(0).val > root.val){
			if (res.size() == 0){
				res.add(pre.get(0));
				res.add(root);
			}else {
				res.set(1, root);
			}
		}
		pre.set(0, root);
		helper(root.right, pre, res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
