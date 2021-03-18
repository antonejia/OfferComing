package com.offer.list;
/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 去除所有重复元素
 * @author bupt
 *
 */
public class DeleteDuplicate2 {

	public static ListNode deleteDuplicates(ListNode head){
		ListNode dummy = new ListNode(0); //添加头结点
		dummy.next = head;
		
		ListNode prev = dummy, p = head;
		while (p != null){
			if (p.next != null && p.val == p.next.val){
				ListNode q = p.next;
				while (q != null && q.val == p.val)
					q = q.next;
				
				prev.next = q;
				p = q;
			}else {
				prev = p;
				p = p.next;
			}
			
		}
		
		return dummy.next;
	}
	public static void main(String[] args) {
		int[] a = {1,1};
		
		ListNode head = ListNode.createList(a);
		
		ListNode.printList(deleteDuplicates(head));

	}

}
