package org.mypro.study.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>给定一个可<strong>包含重复数字</strong>数字的序列 nums ，按任意顺序 返回所有不重复的全排列。</p>
 * 
 * <pre>
 * 
示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 
示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * </pre>
 */
public class Q47 {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		//
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		backTrack(ans, new ArrayList<Integer>(), visited, nums);
		//
		return ans;
	}

	private void backTrack(List<List<Integer>> ans, List<Integer> track, boolean[] visited, int[] nums) {
		// 递归触底条件
		if (track.size() == nums.length) {
			ans.add(new ArrayList<Integer>(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// 满足重复需求选择
			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				continue;
			}

			//
			if (!visited[i]) {
				track.add(nums[i]);
				visited[i] = true;
				backTrack(ans, track, visited, nums);
				//
				track.remove(track.size() - 1);
				visited[i] = false;
			}
		}

	}
}
