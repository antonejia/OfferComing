package com.offer.list;

public class PartitionList {
	/**
	 * 我的代码
	 * @param head
	 * @param x
	 * @return
	 */
	public static ListNode partition(ListNode head, int x){
		if (head == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode ls = dummy, lm = null;//ls保存比x小的链表的尾节点，lm保存比x大的链表的尾节点
		//找到起始状态下ls，和lm的位置
		while (ls.next != null && ls.next.val < x){
			ls = ls.next;
		}
		if (ls.next != null){
			lm = ls.next;
		}else {//ls.next == null 说明所有元素都比x小，直接返回
			return dummy.next;
		}
		
		ListNode cur = lm.next, t;
		lm.next = null;//lm.next置空
		
		while (cur != null){
			if (cur.val < x){//小于x，将cur插入ls和ls.next之间
				t = cur.next;
				cur.next = ls.next;
				ls.next = cur;
				ls = ls.next;
				
				cur = t;
			}else {//大于x，将cur插入lm的后面，cur.next置空
				t = cur.next;
				cur.next = null;
				lm.next = cur;
				lm = lm.next;
				
				cur = t;
			}
		}
		
		return dummy.next;
		
	}
	/**
	 * 别人的代码
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition2(ListNode head, int x) {
        if(head == null) return null;
 
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;
 
        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
 
        while(p != null){
            if(p.val < x){
                p = p.next;
                prev = prev.next;
            }else{
 
                p2.next = p;
                prev.next = p.next;
 
                p = prev.next;
                p2 = p2.next;
            } 
        }
 
        // close the list
        p2.next = null;
 
        prev.next = fakeHead2.next;
 
        return fakeHead1.next;
    }
	public static void main(String[] args) {
		int[] a = {1};
		ListNode head = ListNode.createList(a);
		
		ListNode.printList(partition(head, 2));

	}

}
