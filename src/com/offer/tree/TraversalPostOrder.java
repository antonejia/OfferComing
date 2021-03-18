package com.offer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * http://blog.csdn.net/linhuanmars/article/details/22009351
 * 我们需要维护当前遍历的cur指针和前一个遍历的pre指针来追溯当前的情况（注意这里是遍历的指针，并不是真正按后序访问顺序的结点）
 *（1）如果pre的左孩子或者右孩子是cur，那么说明遍历在往下走，按访问顺序继续，即如果有左孩子，则是左孩子进栈，否则如果有右孩子，则是右孩子进栈，如果左右孩子都没有，则说明该结点是叶子，可以直接访问并把结点出栈了。
（2）如果反过来，cur的左孩子是pre，则说明已经在回溯往上走了，但是我们知道后序遍历要左右孩子走完才可以访问自己，所以这里如果有右孩子还需要把右孩子进栈，否则说明已经到自己了，可以访问并且出栈了。
（3）如果cur的右孩子是pre，那么说明左右孩子都访问结束了，可以轮到自己了，访问并且出栈即可。
 * @author bupt
 *
 */
public class TraversalPostOrder {

	public static List<Integer> postOrder(TreeNode root){
		List<Integer> l = new ArrayList<Integer>();
		if (root == null)
			return l;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode pre = null, cur;
		s.push(root);
		while (!s.isEmpty()){
			cur = s.peek();
			if (pre == null || pre.left == cur || pre.right == cur){
				//继续往下走，有左子树，先遍历左子树，无左子树，有右子树，遍历右子树，否则左右皆无，输出当前节点.
				if (cur.left != null){
					s.push(cur.left);
				}else if (cur.right != null){
					s.push(cur.right);
				}else {
					l.add(cur.val);
					s.pop();//当前cur的左右已遍历完，输出当前节点，然后从栈中弹出(遍历完的都从栈中弹出，栈中栈顶元素永远是即将再访问的节点)
				}
			}else if (cur.left == pre && cur.right != null){
				s.push(cur.right);
			}else {
				l.add(cur.val);
				s.pop();
			}
			
			pre = cur;
		}
		
		return l;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		root.left = n2;
		root.right = n3;
		n3.left = n4;
		n4.right = n5;
		
		System.out.println(postOrder(root));

	}

}
