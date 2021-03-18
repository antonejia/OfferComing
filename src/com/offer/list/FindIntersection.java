package com.offer.list;
/**
 * 判断两个链表是否有交点
 * 有交点一定成Y形，而非X形
 * @author bupt
 *
 */
public class FindIntersection {

	public static ListNode findIntersection(ListNode la, ListNode lb){
		if (la == null || lb == null){
			return null;
		}
		ListNode pa = la, pb = lb;
		int lena = 1,lenb = 1;
		while (pa.next != null){
			lena++;
			pa = pa.next;
		}
		while (pb.next != null){
			lenb++;
			pb = pb.next;
		}
		
		if (pa != pb )//注意这里，如果有交点pa一定等于pb
			return null;
		pa = la;
		pb = lb;
		if (lena > lenb){
			for (int i = 1; i<=lena-lenb; i++)
				pa = pa.next;
		}
		if(lenb > lena){
			for (int i = 1; i<=lenb-lena; i++)
				pb = pb.next;
		}
		while(pa != null){
			if (pa == pb)
				return pa;
			pa = pa.next;
			pb = pb.next;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a.next = a2;
		a2.next = a3;
		a3.next =a4;
		a4.next =a5;
		
		ListNode b = new ListNode(8);
		
		b.next =a4;
		
		ListNode.printList(findIntersection(a, b));
		
	}

}
