package com.offer.list;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并k个有序链表
 * @author bupt
 *
 */

public class MergeKLists {
	
	/**
	 * 直观的做法：多次合并两个有序链表
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(List<ListNode> lists){
		ListNode head = null;
		for (int i = 0; i < lists.size(); ++i){
			head = mergeTwoLists(head, lists.get(i));
		}
		
		return head;
	}
	
	/**
	 * 与合并两个有序链表类似的做法：
	 * 先将所有节点放入一个优先队列中（自动排序），然后选出最小的（出队列），最小的链表指针后移，再放入队列中，再选最小的，
	 * 重复这个过程，直至队列为空
	 * 总结：我一开始也是按这个思路想的，但是没有想到优先队列这个数据结构，而是想自己排序（得到每次的最小值）
	 * 但是问题是，如果按合并两个有序链表类似的写法，当一个链表到达结尾后，其他的链表如何继续，不知道怎么解决了
	 * 有了优先队列这个数据结构，我们一直往队列中添元素，当所有链表都没有到达结尾的时候，队列中的元素始终是lists.size()，
	 * 当有到结尾的时候，队列中的元素变少（剩几个队列就几个元素），就这样继续往下执行，遍历完剩余链表的所有元素。
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists2(List<ListNode> lists){
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), 
				new Comparator<ListNode>(){
			
					public int compare(ListNode o1, ListNode o2) {
						if (o1.val > o2.val){
							return 1;
						}else if (o1.val < o2.val){
							return -1;
						}
						return 0;
					}
			
		});
		
		ListNode head = new ListNode(0), prev = head; //head is the head node of the result list, prev is the last node of the result node 
		//构建初始优先队列
		for (ListNode l : lists){
			q.add(l);
		}
		
		while (!q.isEmpty()){
			ListNode tmp = q.poll();
			prev.next = tmp;//poll the minimum from the q, add it to the last of the prev
			
			if (tmp.next != null){//add tmp.next to the q, == 指针后移
				q.add(tmp.next);
			}
			
			prev = prev.next; //prev 后移
		}
		
		return head.next;
	}
	
	public static ListNode mergeTwoLists(ListNode la, ListNode lb){
		ListNode pa = la, pb = lb;
		ListNode head = new ListNode(0), m = head;
		
		while (pa != null && pb != null){
			if (pa.val < pb.val){
				m.next = pa;
				pa = pa.next;
			}else {
				m.next = pb;
				pb = pb.next;
			}
			m = m.next;
		}
		
		if (pa != null){
			m.next = pa;
		}
		if (pb != null){
			m.next = pb;
		}
		
		return head.next;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
