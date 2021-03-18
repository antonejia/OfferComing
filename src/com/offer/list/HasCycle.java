package com.offer.list;

/**
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
	
	Follow up:
	Can you solve it without using extra space?
 * @author bupt
 *
 */
public class HasCycle {

	public static boolean hasCycle(ListNode head){
		if (head == null)
			return false;
		
		ListNode fast = head, slow = head;
		boolean flag = false;//是否再次相遇
		
		while (fast.next != null && fast.next.next != null){	
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow){
				return true;
			}
		}
		
		if (flag)
			return true;
		
		return false;
	}
	/**
	 * 别人的代码：
	 * 优点：
	 * 考虑到head==null的情况，统一代码，不用开头额外判断
	 * 无需flag，当fast==slow时直接返回true
	 * @param head
	 * @return
	 */
	public static boolean hasCycle2(ListNode head){
		ListNode fast = head, slow = head;
		
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow)
				return true;
				
		}
		
		return false;
	}
	/**
	 * 有环的话找出环开始的节点
	 * 参考leetcode-cpp.pdf
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle(ListNode head){
		ListNode fast = head, slow = head;
		
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow){
				ListNode slow2 = head;
				while (slow2 != slow){
					slow2 = slow2.next;
					slow = slow.next;
				}
				return slow;
			}
				
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		
		head.next = head;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		
		System.out.println(hasCycle2(head));

	}

}
