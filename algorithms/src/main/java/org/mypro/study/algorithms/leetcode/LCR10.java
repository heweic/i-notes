package org.mypro.study.algorithms.leetcode;

import java.util.HashMap;

/**
 * 和为K的子数组个数
 * 
 */
public class LCR10 {
	public int subarraySum(int[] nums, int k) {
		
		int count = 0 ;
		int prefixSum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		
		for(int num : nums) {
			prefixSum += num;
			if(map.containsKey(prefixSum - k)) {
				count += map.get(map.get(prefixSum - k));
			}
			//
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		//
		return count;
		
	}
}
