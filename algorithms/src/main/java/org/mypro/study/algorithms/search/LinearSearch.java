package org.mypro.study.algorithms.search;

import org.mypro.study.algorithms.sort.CompareSort;

public class LinearSearch {

	
	public static void main(String[] args) {
		
		// O(n)
		int[] arr = CompareSort.randomArr(10);
		int n = arr.length;
		
		int target = arr[5];
		
		for (int i = 0; i < n; i++) {
			if(arr[i] == target) {
				System.out.println("find" + i);
				break;
			}
		}
	}
}
