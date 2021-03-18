package com.offer.list;

import java.util.HashMap;
import java.util.Map;

/**
 * http://blog.csdn.net/linhuanmars/article/details/22463599
 * http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
 * @author bupt
 *
 */
class RandomListNode{
	int label;
	RandomListNode next, random;
	
	public RandomListNode(int x){
		this.label = x;
		this.next = null;
		this.random = null;
	}
}
public class CopyList {

	/**
	 * 两遍扫描，一次复制next节点，一次复制random节点
	 * HashMap的作用
	 * @param head
	 * @return
	 */
	public static RandomListNode copyRandomList(RandomListNode head){
		if (head == null)
			return null;
		//HashMap的作用：key存储原节点，value存储对应的复制节点，是为了在第二轮复制（复制random节点）时，将新节点的random指向新的节点
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode cur1 = head.next, cur2 = newHead;
		
		map.put(head, newHead);
		
		//先复制next节点
		while(cur1 != null){
			cur2.next = new RandomListNode(cur1.label);
			cur2 = cur2.next;
			map.put(cur1, cur2);
			
			cur1 = cur1.next;
		}
		
		//再复制random节点
		cur1 = head;
		cur2 = newHead;
		while(cur1 != null){
			cur2.random = map.get(cur1.random);
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		
		return newHead;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
