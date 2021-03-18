package com.offer.list;
/**
 * 两个有序链表合并
 * @author bupt
 *
 */


public class MergeTwoLists {

	/**
	 * 我的版本，没有加头指针，所以会多出 1 和 2之间的代码
	 * @param la
	 * @param lb
	 * @return
	 */
	public static ListNode mergeTwoSortedLists(ListNode la, ListNode lb){
		if (la == null){
			return lb;
		}
		if (lb == null){
			return la;
		}
		ListNode r = null, m = null, p = la, q = lb;
		// 1
		if (p.val < q.val){
			r = p;
			m = r;
			p = p.next;
		}else {
			r = q;
			m = q;
			q = q.next;
		}
		// 2
		while (p != null && q != null){
			if (p.val < q.val){
				m.next = p;
				m = m.next;
				p = p.next;
			}else{
				m.next = q;
				m = m.next;
				q = q.next;
			}
		}
		if (p != null){
			m.next = p;
		}
		if (q != null){
			m.next = q;
		}
		
		
		return r;
	}
	
	/**
	 * 利用头指针简化
	 * @param la
	 * @param lb
	 * @return
	 */
	public static ListNode mergeTwoSortedLists2(ListNode la, ListNode lb){
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
		int[] a = {1,4,5,10,15};
		int[] b = {3,7,8,11,16};
		
		ListNode la = ListNode.createList(a);
		ListNode lb = ListNode.createList(b);
		
		ListNode.printList(la);
		ListNode.printList(lb);
		
		ListNode.printList(mergeTwoSortedLists2(la, lb));
	}
	
	

}
