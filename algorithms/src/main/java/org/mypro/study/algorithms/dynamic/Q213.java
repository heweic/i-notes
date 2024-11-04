package org.mypro.study.algorithms.dynamic;

/**
 * 打家劫舍2
 * 
 * @author hew
 *
 *         <pre>
	相比较1，房屋是围成圈的
 *         </pre>
 */
public class Q213 {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		//
		return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));

	}

	private int robRange(int[] nums, int start, int end) {
		int prev2 = 0;
		int prev1 = 0;

		for (int i = start; i <= end; i++) {
			int curent = Math.max(prev1, prev2 + nums[i]);
			prev2 = prev1;
			prev1 = curent;
		}

		return prev1;
	}
}
