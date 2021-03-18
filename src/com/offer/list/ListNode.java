package com.offer.list;

public class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val){
		this.val = val;
		next = null;
	}
	/**
	 * 根据数组 a 构建list
	 * @param a
	 * @return
	 */
	public static ListNode createList(int[] a){
		ListNode l = new ListNode(0), p = l;
		
		for (int aa : a){
			p.next = new ListNode(aa);
			p = p.next;
		}
		
		return l.next;
	}
	
	/**
	 * 打印链表
	 * @param l
	 */
	public static void printList(ListNode l){
		while (l != null){
			System.out.print(l.val+", ");
			l = l.next;
		}
		System.out.println();
	}
}
