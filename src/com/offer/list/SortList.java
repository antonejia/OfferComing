package com.offer.list;

import com.offer.list.ListNode;

/**
 * https://oj.leetcode.com/problems/sort-list/
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 时间复杂度：O(n*logn)
 * 空间复杂度：O(1)
 * 总结：单链表排序适合用归并排序，双向链表排序适合用快速排序
 * 
 *
 */
public class SortList {

	public static ListNode sortList(ListNode head){
		if (head == null || head.next == null)
			return head;
		
		//快慢指针找到链表中间节点
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		
		ListNode head2 = slow.next;
		slow.next = null; //断链！！
		
		ListNode headNew = sortList(head); //排序左链表
		ListNode head2New = sortList(head2); //排序右链表
		
		return mergeTwoSortedLists(headNew, head2New); //合并两个有序链表
	}
	/**
	 * 合并两个有序链表
	 * @param la
	 * @param lb
	 * @return
	 */
	public static ListNode mergeTwoSortedLists(ListNode la, ListNode lb){
		ListNode pa = la, pb = lb;
		
		ListNode head = new ListNode(0);//结果链表的头指针
		ListNode m = head;//结果链表的最后一个节点，为了在尾部插入节点
		
		while (pa != null && pb != null){
			if (pa.val < pb.val){
				m.next = pa;
				pa = pa.next;
			}else {
				m.next = pb;
				pb = pb.next;
			}
			m = m.next;//!!!
		}
		
		if (pa != null)
			m.next = pa;
		if (pb != null)
			m.next = pb;
		
		return head.next;
	}
	
	public static void main(String[] args) {
		int[] a = {10,4,5,3,13};
		
		ListNode la = ListNode.createList(a);
		
		ListNode.printList(la);
		
		ListNode.printList(sortList(la));
	}

}
