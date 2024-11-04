package org.mypro.study.algorithms.backTracking;

import java.util.Arrays;

/**
 * 划分为K个相等的子集
 * 
 * @author hew
 *
 *         <pre>
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

 

示例 1：

输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
示例 2:

输入: nums = [1,2,3,4], k = 3
输出: false
 *         </pre>
 */
public class Q698 {

	public boolean canPartitionKSubsets(int[] nums, int k) {

		int sum = Arrays.stream(nums).sum();
		if (sum % k != 0) {
			return false;
		}
		int target = sum / k;
		Arrays.sort(nums);
		if (nums[nums.length - 1] > target) {
			return false;
		}
		//
		int[] buckets = new int[k];

		return backTrack(nums, buckets, nums.length - 1, target);

	}

	private boolean backTrack(int[] nums, int[] buckets, int index, int target) {
		if (index < 0) {
			return true;
		}
		int num = nums[index];
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] + num <= target) {
				buckets[i] += num;
				//
				if (backTrack(nums, buckets, index - 1, target)) {
					return true;
				}
				//
				buckets[i] -= num;
			}
			if (buckets[i] == 0) {
				break;
			}
		}
		return false;
	}

}
