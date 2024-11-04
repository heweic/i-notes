package org.mypro.study.algorithms.leetcode;

/**
 * 合并K个有序链表
 * 分治思想
 */

public class A23 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		return mergeLists(lists, 0, lists.length - 1);
	}

	private ListNode mergeLists(ListNode[] lists, int left, int right) {
		if (left == right) {
			return lists[left];
		}
		int mid = left + (right - left) / 2;
		ListNode l1 = mergeLists(lists, left, mid);
		ListNode l2 = mergeLists(lists, mid + 1, right);
		return mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else if (list1.val <= list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}

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
