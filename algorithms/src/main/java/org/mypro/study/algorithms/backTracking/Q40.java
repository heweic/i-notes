package org.mypro.study.algorithms.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和2
 * 
 * @author hew
 *
 *         <pre>
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。

 示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]
 * 
 *         </pre>
 */
public class Q40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		//
		Arrays.sort(candidates);
		backTrack(candidates, target, 0, new ArrayList<Integer>(), ans);
		//
		return ans;
	}

	private void backTrack(int[] candidates, int target, int start, List<Integer> track, List<List<Integer>> ans) {
		if (target == 0) {
			ans.add(new ArrayList<Integer>(track));
			return;
		}
		//

		//
		for (int i = start; i < candidates.length; i++) {
			int num = candidates[i];
			//
			if (num > target) {
				break;
			}
			// 去重
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			//
			track.add(num);
			backTrack(candidates, target - num, i + 1, track, ans);
			track.remove(track.size() - 1);

		}
	}
}
