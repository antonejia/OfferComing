package com.offer.list;
/**
 * 单链表反转
 * @author bupt
 *
 */
public class ReverseList {

	public static ListNode reverseList(ListNode l){
		if (l == null)
			return null;
		
		ListNode p = l, q = p.next, r;//p是最终链表的头结点，q遍历当前链表，r保存q的后缀，防止断链
		p.next = null;//!!!!注意这里，不要忘记
		while (q != null){
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		
		return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,4,5,10,15};
		
		ListNode la = ListNode.createList(a);
		
		ListNode.printList(reverseList(la));
		
	}
	

}
