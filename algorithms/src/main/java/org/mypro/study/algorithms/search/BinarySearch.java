package org.mypro.study.algorithms.search;

/**
 * 二分法搜索 O(log n)
 */
public class BinarySearch {

	public static void main(String[] args) {
		
	
		

		int[] arr = new int[] { 1, 5, 7, 9, 12, 15, 17 };

		int target = 7;

		System.out.println(search(arr, 0, arr.length - 1, target));

	}

	private static int search(int[] arr, int left, int right, int target) {

		if (left > right) {
			return -1;
		}
		// 计算中间位置索引
		int mid = left + (right - left) / 2;
		//
		if (target == arr[mid]) {
			return mid;
		} else if (target < arr[mid]) {
			return search(arr, left, mid - 1, target);
		} else {
			return search(arr, mid + 1, right, target);
		}
		
		//
	}

}
