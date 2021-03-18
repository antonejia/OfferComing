package com.offer.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree<AnyType> {

	private BinaryNode<AnyType> root;
	
	public BinaryTree(){
		//root = new BinaryNode<AnyType>();
		//root.left = new BinaryNode<AnyType>();
		//root.right = new BinaryNode<AnyType>();
		//System.out.println("bTree.root = " + root);
		this(null);
	}
	public BinaryTree(BinaryNode<AnyType> root){
		this.root = root;
	}
	public BinaryNode<AnyType> getRoot(){
		return root;
	}
	public void setRoot(BinaryNode<AnyType> root){
		this.root = root;
	}
	
	/*****************************************************************************************
		各种操作
	*****************************************************************************************/
	/**
	 * 创建二叉树，输入为 -1 时表示节点为空(根据先序序列创建)
	 */
	public static BinaryNode<Integer> createTree(Scanner scanner){
		int n = scanner.nextInt();
		//递归结束
		if (n == -1){
			return null;
		}
		BinaryNode<Integer> bNode = new BinaryNode<Integer>();
		
		bNode.data = n;
		BinaryNode<Integer> left = createTree(scanner);
		BinaryNode<Integer> right = createTree(scanner);
		
		bNode.left = left;
		bNode.right = right;
		
		return bNode;
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
	/**
	 * 层次遍历
	 * @param root
	 */
	public void layerOrder(BinaryNode<AnyType> root){
		Queue<BinaryNode<AnyType>> queue = new LinkedList<BinaryNode<AnyType>>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryNode<AnyType> node = queue.poll();
			System.out.print(node.data+", ");
			if (node.left != null){
				queue.offer(node.left);
			}
			if (node.right != null){
				queue.offer(node.right);
			}
		}
	}
	/**
	 * 先序遍历：递归
	 * @param bNode : 根节点
	 */
	public void preOrder(BinaryNode<AnyType> bNode){
		if (bNode != null){
			System.out.print(bNode.data+", ");
			preOrder(bNode.left);
			preOrder(bNode.right);
		}
	}
	/**
	 * 先序遍历：非递归
	 * 栈 保存已经访问过的节点，
	 * 一直遍历左节点直至为空，这时弹出栈中刚访问过的元素，指向他的右节点接续访问
	 * @param bNode
	 */
	public void preOrder_iter(BinaryNode<AnyType> root){
		BinaryNode<AnyType> p = root;
		Stack<BinaryNode<AnyType>> stack = new Stack<BinaryNode<AnyType>>();
		while(p != null || !stack.empty()){
			if (p != null){
				System.out.print(p.data+", ");
				stack.push(p);
				p = p.left;
			}else {
				p = stack.pop();
				p = p.right;
			}
			
		}
	}
	/**
	 * 中序遍历：递归
	 * @param bNode
	 */
	public void inOrder(BinaryNode<AnyType> bNode){
		if (bNode != null){
			inOrder(bNode.left);
			System.out.print(bNode.data+", ");
			inOrder(bNode.right);
		}
	}
	/**
	 * 中序遍历：非递归
	 * @param bNode
	 */
	public void inOrder_iter(BinaryNode<AnyType> bNode){
		BinaryNode<AnyType> p = bNode;
		Stack<BinaryNode<AnyType>> stack = new Stack<BinaryNode<AnyType>>();
		while (p != null || !stack.empty()){
			if (p != null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				System.out.print(p.data + ", ");
				p = p.right;
			}
		}
	}
	
	/**
	 * 后序遍历：递归
	 * @param bNode
	 */
	public void postOrder(BinaryNode<AnyType> bNode){
		if (bNode != null){
			postOrder(bNode.left);
			postOrder(bNode.right);
			System.out.print(bNode.data+", ");
		}
	}
	/**
	 * 后序遍历：非递归
	 * @param root
	 */
	public void postOrder_iter(BinaryNode<AnyType> root){
		Stack<BinaryNode<AnyType>> s1 = new Stack<BinaryNode<AnyType>>();
		Stack<BinaryNode<AnyType>> s2 = new Stack<BinaryNode<AnyType>>();
		BinaryNode<AnyType> p = root;
		
		while (p != null || !s1.empty()){
			if (p != null){
				//p不为空，直接压栈，s1，s2都入，然后继续沿左子树往下走
				s1.push(p);
				s2.push(p);
				p = p.left;
			}else {
				if (s2.size() > 0 && s1.peek().data == s2.peek().data){
					//栈顶元素相同：说明栈顶元素的左子树已经遍历完，现在该遍历右子树
					//s2出栈，下一次s1中再次遇到相同的栈顶元素时，两个栈顶必不相同，
					p = s2.pop().right;
					
				}else {
					//栈顶元素不同：说明s1栈顶元素的左右子树都已遍历完成，s1出栈，输入该节点
					System.out.print(s1.pop().data + ", ");
				}
			}
		}
		
	}
	/**
	 * 在数组ino，下标从startIno到startIno + len - 1中寻找k，返回下标
	 * @param ino
	 * @param k
	 * @param startIno
	 * @param len
	 * @return
	 */
	public int search(int[] ino, int k, int startIno, int len){
		for (int i = startIno; i < startIno + len; i++){
			if (ino[i] == k){
				return i;
				
			}
		}
		return -1;
	}
	/**
	 * 根据前序和中序序列重建二叉树
	 * @param pre 前序数组
	 * @param ino 中序数组
	 * @param startPre 数组开始位置
	 * @param startIno
	 * @param len 长度，定位从哪位到哪位构建
	 * @return
	 */
	public BinaryNode<Integer> createTreeByPreAndInOrder(int[] pre, int[] ino, int startPre, int startIno, int len){
		//递归结束条件
		if (len == 0){
			return null;
		}
		int rootData = pre[startPre];
		int k = search(ino, rootData, startIno, len);
		if (k == -1){
			return null;
		}
		BinaryNode<Integer> root = new BinaryNode<Integer>();
		root.data = rootData;

		BinaryNode<Integer> left = createTreeByPreAndInOrder(pre, ino, startPre+1, startIno, k-startIno);
		BinaryNode<Integer> right = createTreeByPreAndInOrder(pre, ino, startPre + (k-startIno)+1, k+1, len-(k-startIno)-1);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
	/**
	 * 以下为错误写法
	 * 原因在于函数传参为对象问题，要想函数内部对参数的修改作用于函数调用结束后，就必须做到参数对象不能指向新的new对象
	 * 具体请参考自己笔记（Java参数传值传引用问题）
	 */
	public BinaryNode<Integer> createTreeByPreAndInOrder2(BinaryNode<Integer> root, int[] pre, int[] ino, int startPre, int startIno, int len){
		//递归结束条件
		if (len == 0){
			return null;
		}
		int rootData = pre[startPre];
		int k = search(ino, rootData, startIno, len);
		if (k == -1){
			return null;
		}
		root = new BinaryNode<Integer>();// 1
		root.data = rootData;
		root.left = null; //这样写之后，后面递归调用后在 1 处又重新指向了新的对象，这种修改只作用于函数内部
		root.right = null;
		createTreeByPreAndInOrder2(root.left, pre, ino, startPre+1, startIno, k-startIno);
		createTreeByPreAndInOrder2(root.right, pre, ino, startPre + k - startIno+1, k+1, len-k+startIno-1);
		
		return root;
	}
	
	public static void main(String[] args){
/*		BinaryNode<Integer> root = new BinaryNode<Integer>(1);
		BinaryNode<Integer> node2 = new BinaryNode<Integer>(2);
		BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
		BinaryNode<Integer> node4 = new BinaryNode<Integer>(4);
		BinaryNode<Integer> node5 = new BinaryNode<Integer>(5);
		BinaryNode<Integer> node6 = new BinaryNode<Integer>(6);
		System.out.println(root.left == null);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;*/
		
		Scanner scanner = new Scanner(System.in);
		BinaryTree<Integer> bTree = new BinaryTree<Integer>();
		BinaryNode<Integer> root = BinaryTree.createTree(scanner);
		
		bTree = new BinaryTree<Integer>(root);
		System.out.println("凹入型打印树：");
		bTree.printTree(bTree.getRoot(), 0);
		
		System.out.println("层次遍历：");
		bTree.layerOrder(bTree.getRoot());
		
		System.out.println("\n前序递归遍历：");
		bTree.preOrder(bTree.getRoot());
		System.out.println("\n前序非递归遍历：");
		bTree.preOrder_iter(bTree.getRoot());
		
		System.out.println("\n中序递归遍历：");
		bTree.inOrder(bTree.getRoot());
		System.out.println("\n中序非递归遍历：");
		bTree.inOrder_iter(bTree.getRoot());
		
		System.out.println("\n后序递归遍历：");
		bTree.postOrder(bTree.getRoot());
		System.out.println("\n后序非递归遍历：");
		bTree.postOrder_iter(bTree.getRoot());
		
		System.out.println("\n已知前序和中序构造二叉树：");
		BinaryNode<Integer> root2 = null;
		int [] pre = {1,2,4,5,3,6};
		int [] ino = {4,2,5,1,6,3};
		root2 = bTree.createTreeByPreAndInOrder(pre, ino, 0, 0, 6);
		
		BinaryTree<Integer> bTree2 = new BinaryTree<Integer>(root2);
		System.out.println("\n层次遍历：");
		bTree2.layerOrder(bTree2.getRoot());
		
	}

}
