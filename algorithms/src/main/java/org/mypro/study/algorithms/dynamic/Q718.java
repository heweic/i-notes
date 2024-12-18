package org.mypro.study.algorithms.dynamic;

/**
 * 最长重复子数组
 * 
 * @author hew
 *
 *         <pre>
给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
示例 1：
输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
输出：3
解释：长度最长的公共子数组是 [3,2,1] 。
示例 2：
输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
输出：5
 *         </pre>
 */
public class Q718 {

	public int findLength(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int[][] dp = new int[m + 1][n + 1];
		int maxLength = 0;
		for(int i = 1 ; i <= m ; i ++) {
    		for(int j =1 ; j <= n ; j ++) {
    			if(nums1[i -1] == nums2[j -1]) {
    				dp[i][j] = dp[i -1][j -1] + 1;
    				maxLength = Math.max(maxLength, dp[i][j]);
    			}else {
    				dp[i][j] = 0;
    			}
    		}
    	}
    	return maxLength;
	}

}
