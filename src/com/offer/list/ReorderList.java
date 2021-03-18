package com.offer.list;
/**
 * https://oj.leetcode.com/problems/reorder-list/
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	You must do this in-place without altering the nodes' values.
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author bupt
 *
 */
public class ReorderList {
	/**
	 * 保持head不动，反转后面的
	 * @param head
	 */
	public static void reverseList(ListNode head){
		if (head == null || head.next == null){
			return ;
		}
		
		ListNode p = head.next, q = p.next, r;
		p.next = null;
		while (q != null){//头插法，q插到p的前面
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		
		head.next = p;
	}
	
	public static void reorderList(ListNode head){
		if (head == null || head.next == null){
			return ;
		}
		
		//快慢指针找到链表中间节点
		ListNode fast = head.next, slow = head.next;
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		//slow是中间节点，反转slow之后的所有元素（不包括slow）
		reverseList(slow);
		//ListNode.printList(slow);
		
		//合并前后两个链表
		ListNode p = slow.next, q = head.next, cur = head;
		slow.next = null;//!!断链
		
		while (q != slow && p != null){
			cur.next = p;
			cur = cur.next;
			p = p.next;
			
			cur.next = q;
			cur = cur.next;
			q = q.next;
		}
		if (p != null){ //head之后节点总数为偶数的情况
			cur.next = p;
			cur = cur.next;
			cur.next = q;
		}else {
			cur.next = q;
		}
	
	}
	
	public static void main(String[] args) {
		int[] a = {1,2};
		ListNode head = ListNode.createList(a);
		
		reorderList(head);
		ListNode.printList(head);
	}

}
