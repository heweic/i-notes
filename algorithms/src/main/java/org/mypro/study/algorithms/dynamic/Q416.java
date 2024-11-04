package org.mypro.study.algorithms.dynamic;

import java.util.Arrays;

/**
 * 分割等和子集
 * 
 * @author hew
 *
 *         <pre>
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 *         </pre>
 */
public class Q416 {
	
	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		
		if(sum % 2 != 0) {
			return false;
		}
		int target = sum /2;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		
		for(int num : nums) {
			for(int j = target ; j >= num; j --) {
				dp[j] = dp[j] || dp[j-num];
			}
		}
		return dp[target];
		
	}
}
