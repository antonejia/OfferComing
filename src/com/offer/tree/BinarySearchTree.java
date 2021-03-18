package com.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	private BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	
	public void printTree(){
		
	}
	private void printTree(BinaryNode<AnyType> node){
		
	}
	/**
	凹入型打印二叉树
	*/
	public void printTree(BinaryNode<AnyType> bNode, int depth){
		//StringBuffer s = ""; //这样写是不对的
		StringBuffer s = new StringBuffer("");
		for (int i = 0; i < depth; ++i){
			s.append("  ");
		}
		s.append(bNode.data);
		System.out.println(s);
		if (bNode.left != null){
			printTree(bNode.left, depth+1);
		}
		if (bNode.right != null){
			printTree(bNode.right, depth+1);
		}
	}
	public boolean contains(AnyType x){
		return contains2(x, root);
	}
	
	private boolean contains(AnyType x, BinaryNode<AnyType> node){
		if (node == null){
			return false;
		}
		int t = x.compareTo(node.data); //注意这里，是compareTo
		if (t < 0){
			return contains(x, node.left);
		}else if(t > 0) {
			return contains(x, node.right);
		}else{ //把最不可能出现的情况放在最后
			return true;
		} 
	}
	/**
	 * 非递归实现
	 */
	private boolean contains2(AnyType x, BinaryNode<AnyType> node){
		BinaryNode<AnyType> p = node;
		while(p != null){
			int t = x.compareTo(p.data); //注意这里，是compareTo
			if (t < 0){
				p = p.left;
			}else if(t > 0) {
				p = p.right;
			}else{ //把最不可能出现的情况放在最后
				return true;
			} 
		}
		
		return false;
	}
	public AnyType findMin(){
		if (isEmpty()){
			return null;
		}
		
		return findMin(root).data;
	}
	/**
	 * 找最小值：递归
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node){
		if (node == null){
			return null;
		}else if (node.left == null){
			return node;
		}
		return findMin(node.left);
	}
	/**
	 * 找最小值：非递归
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMin2(BinaryNode<AnyType> node){
		if (node != null){
			while(node.left != null){
				node = node.left;
			}
		}
		return node;
	}
	public AnyType findMax(){
		if (isEmpty()){
			return null;
		}
		
		return findMax(root).data;
	}
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node){
		if (node != null){
			while(node.right!= null){
				node = node.right;
			}
		}
		return node;
	}
	public void insert(AnyType x){
		root = insert2(x, root);
		//root = insert(x, root);
	}
	/**
	 * 非递归插入
	 * @param x
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> node){
		if (node == null){
			node = new BinaryNode<AnyType>(x);
		}else {
			int flag = 0; //flag记录是插入在q的左节点，还是右节点
			BinaryNode<AnyType> p = node;
			BinaryNode<AnyType> q = node; //q记录p的父节点，
			while (p != null){
				if (x.compareTo(p.data) < 0){
					q = p;
					p = p.left;
				}else if (x.compareTo(p.data) > 0){
					q = p;
					p = p.right;
					flag = 1;
				}else {
					return node;
				}
			}
			if (flag == 0){
				q.left = new BinaryNode<AnyType>(x);
			}else {
				q.right = new BinaryNode<AnyType>(x);
			}
		}
		
		return node;
	}
	/**
	 * 递归插入（注意这里函数为什么有返回值，原因同BinaryTree中的createTreeByPreAndInOrder2）
	 * @param x
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> insert2(AnyType x, BinaryNode<AnyType> node){
		if (node == null){
			return new BinaryNode<AnyType>(x);
		}
		
		int compareResult = x.compareTo(node.data);
		if (compareResult < 0){
			node.left = insert(x, node.left); //注意这里函数为什么即使传入了参数也要有返回值，
		}else if (compareResult > 0){
			node.right = insert(x, node.right);
		}else {
			
		}
		return node;
	}
	public void remove(AnyType x){
		root = remove(x, root);
	}
	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> node){
		if (node == null){
			return node;
		}
		int cmpResult = x.compareTo(node.data);
		if (cmpResult < 0){
			node.left = remove(x, node.left);
		}else if (cmpResult > 0){
			node.right = remove(x, node.right);
		}else {
			if (node.left != null && node.right != null){
				node.data = findMin(node.right).data;
				node.right = remove(node.data, node.right);
			}else {
				node = (node.left != null) ? node.left : node.right;
			}
		}
		return node;
	}

	/**
	 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
	 * 二叉搜索树中的第K小元素
	 *
	 * 方法1：对树进行中序遍历，存到有序数据中，然后自然就知道第k小的元素了
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		inOrderTranversal(root, arr);

		return arr.get(k-1);
	}

	/**
	 * 方法2：采用迭代的方式遍历树
	 * （1）从根节点开始遍历，一直找到最左的叶子节点，这时的叶子节点是最小的，看是否=k，如果=k，直接返回
	 * （2）否则，找第二小的叶子节点：看第一小的叶子节点是否有right节点，（相当于将该节点的right节点作为根节点，重复步骤1）
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest2(TreeNode root, int k) {
		/* 我的写法 ，如此的烂
		LinkedList<Integer> stack = new LinkedList<Integer>();

		while(true) {
			stack.add(root.val);
			while(root.left != null) {
				root = root.left;
				stack.add(root.val);
			}

			if(--k == 0) {
				return stack.getLast();
			}

			stack.removeLast();

			root = root.right;
		}*/

		// stack的作用：存储DFS中的过程节点，便于依次找出来最小的
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

		while(true) {

			while(root != null) {
				stack.add(root);
				root = root.left;
			}

			root = stack.removeLast();
			if(--k == 0) {
				return root.val;
			}

			root = root.right;
		}


	}



	public void inOrderTranversal(TreeNode root, ArrayList<Integer> arr) {
		if(root == null) {
			return;
		}

		if(root.left != null) {
			inOrderTranversal(root.left, arr);
		}

		arr.add(root.val);

		if(root.right != null) {
			inOrderTranversal(root.right, arr);
		}
	}
	
	public static void main(String[] args){
		BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
		int[] a = {5,2,3,6,7,4};
		//构建树
		for (int i : a){
			bsTree.insert(new Integer(i));
		}
		bsTree.printTree(bsTree.root, 0);
		int contains = 8;
		System.out.println("树包含"+contains+"?  "+bsTree.contains(contains));
		
		System.out.println("最小值："+bsTree.findMin());
		System.out.println("最大值："+bsTree.findMax());
	}
	
}
