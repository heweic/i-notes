package org.mypro.study.algorithms.leetcode;

/*
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
回文链表
。如果是，返回 true ；否则，返回 false 。
 */
public class Q234 {

	private ListNode prev;

	public boolean isPalindrome(ListNode head) {

		this.prev = head;
		check(head);
		return check(head);
	}

	private boolean check(ListNode tail) {
		if (null != tail) {
			if (!check(tail.next)) {
				return false;
			}
			if (tail.val == prev.val) {
				return true;
			}
			prev = prev.next;
		}
		return false;

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
