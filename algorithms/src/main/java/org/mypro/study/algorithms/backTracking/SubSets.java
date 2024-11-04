package org.mypro.study.algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算数组的所有子集
 */
public class SubSets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		backtrack(result, new ArrayList<Integer>(), nums, 0);
		return result;
	}

	private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {

		//
		if (start == nums.length) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		int i = start;

		backtrack(result, temp, nums, i + 1);
		//
		temp.add(nums[i]);
		backtrack(result, temp, nums, i + 1);

		//
		temp.remove(temp.size() - 1);

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		//
		List<List<Integer>> subsets = subsets(nums);
		System.err.println("--------------");
		for (List<Integer> suset : subsets) {
			System.out.println(suset);
		}
	}

}
