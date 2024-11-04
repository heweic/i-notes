package org.mypro.study.algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 全排列 给定一个<strong>不含重复数字</strong>的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * <pre>
 示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * </pre>
 */
public class Q46 {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		//

		backTrack(ans, new ArrayList<Integer>(), nums);
		//
		return ans;
	}

	private void backTrack(List<List<Integer>> ans, List<Integer> track, int[] nums) {
		// 递归触底条件
		if (track.size() == nums.length) {
			ans.add(new ArrayList<Integer>(track));
			return;
		}

		for (int num : nums) {
			if (track.contains(num)) {
				continue;
			}
			//
			track.add(num);
			backTrack(ans, track, nums);
			//
			track.remove(track.size() - 1);
		}

	}
}
