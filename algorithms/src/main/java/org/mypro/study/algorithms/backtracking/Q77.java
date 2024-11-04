package org.mypro.study.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 
 * 你可以按 任何顺序 返回答案。
 */
public class Q77 {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//
		backtrack(result, new ArrayList<Integer>(), n, 0, k);
		//
		return result;
	}

	private static void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int start, int k) {
		//题目要求子集个数为K，当子集数达到k的时候，递归触底
		if (temp.size() == k) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		//
		for(int i = start ; i <= n ; i ++) {
			
			//
			temp.add(i);
			backtrack(result, temp, n, i + 1,k);
			//
			temp.remove(temp.size() - 1);
		}

	}
}
