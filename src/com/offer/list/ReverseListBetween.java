package com.offer.list;

/**
 * 此题还是比较麻烦的，边界条件比较繁琐
 * 注意的地方时两个while的结束边界条件
 * @author bupt
 *
 */
public class ReverseListBetween {

	public static ListNode reverseBetween(ListNode l, int m, int n){
		if (l == null)
			return null;
		
		ListNode dummy = new ListNode(-1);//虚拟头结点，目的是为了照顾m == 1的情形
		dummy.next = l;
		ListNode head = dummy; //head保存结点 m(要反转的起始结点)的前驱
		
		int i = 1;
		while (i < m){
			//循环m-1次，得到要反转的起始结点的前驱
			head = head.next;
			i++;
		}
		
		//下面这段跟反转整个单链表代码一样，但是不同的是pp要将头结点保存下来，因为最后要修改它的后驱
		ListNode pp = head.next, p = head.next, q = p.next, r;
		while (i < n){//!!
			r = q.next;
			q.next = p;
			p = q;
			q = r;
			i++;
		}
		
		head.next = p; //m的前驱链
		pp.next = q; //q的前驱链
		
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6};
		ListNode l = ListNode.createList(a);
		
		ListNode.printList(l);
		ListNode.printList(reverseBetween(l, 1, 6));
	}

}
