package com.offer.list;
/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 链表去重
 * @author bupt
 *
 */
public class DeleteDuplicates {
	/**
	 * 方法1：两个指针（我的实现方法）
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head){
		if(head == null)
			return null;
		
		ListNode p = head, q = head.next;
		while (q != null){
			if (q.val == p.val){
				q = q.next;
				p.next = q;
			}else{
				p = p.next;
				q = q.next;
			}
		}
		
		return head;
	}
	/**
	 * 方法2：一个指针
	 * @param head
	 * @return
	 */
	 public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;
 
        ListNode p = head;
 
        while( p!= null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next; 
            }
        }
 
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,2,3,3,4};
		
		ListNode head = ListNode.createList(a);
		
		ListNode.printList(deleteDuplicates(head));
	}

}
