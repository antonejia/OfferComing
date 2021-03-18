package com.offer.list;
/**
 * http://www.programcreek.com/2012/12/add-two-numbers/
 * 这里面有另一种解决方案，不过每次都得new ListNode，没我的好，我用la保存最终的结果
 * @author bupt
 *
 */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode la, ListNode lb){
		ListNode pa = la, pb = lb; //pa遍历la，pb遍历lb
		ListNode r = new ListNode(0); //r保存当前pa的前驱，在pa和pb都为空时，如果flag，新建一个节点，r.next = new ListNode(1);
		r.next = pa;
		
		boolean flag = false; //是否进位
		
		while (pa != null || pb != null){ //pa && pb都为空时结束循环，如果遇到一个提前结束要扩充它（填0）使之与另一个等长
			int sum = flag ? (pa.val + pb.val + 1) : (pa.val+pb.val);
			pa.val = sum % 10;
			
			if (sum / 10 == 1){
				flag = true;
			}else {
				flag = false;
			}
			
			r = pa;
			
			if (pa.next == null && pb.next != null) //pa结束，pb没结束，扩充pa
				pa.next = new ListNode(0);
			if (pb.next == null && pa.next != null) //pb结束，pa没结束，扩充pb
				pb.next = new ListNode(0);
			
			pa = pa.next;
			pb = pb.next;
		}
		
		if (flag){//pa和pb都结束，如果要进位，则增加节点1
			r.next = new ListNode(1);
		}
		
		
		return la;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1};
		int[] b = {9,9};
		ListNode la = ListNode.createList(a);
		ListNode lb = ListNode.createList(b);
		
		ListNode.printList(addTwoNumbers(la, lb));

	}

}
