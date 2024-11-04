package org.mypro.study.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集2问题 包含<strong>重复</strong>的数组，求子集，子集不能重复
 *
 * <pre>
示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * </pre>
 */
public class Q90 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {

		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		//
		Arrays.sort(nums);
		backTrack(rs, new ArrayList<Integer>(), nums, 0);
		//
		return rs;
	}
	private static void backTrack(List<List<Integer>> rs ,List<Integer> temp , int[] nums , int start) {
		//
		rs.add(new ArrayList<Integer>(temp));
		//
		for (int i = start; i < nums.length; i++) {
			//如果后一个数与前一个一样，不递归
			if( i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			//
			temp.add(nums[i]);
			backTrack(rs, temp, nums, i + 1); 
			//回溯
			temp.remove(temp.size() - 1);
			
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1 ,2,2};
		//
		List<List<Integer>> subsets = subsetsWithDup(nums);
		System.err.println("--------------");
		for(List<Integer> suset : subsets) {
			System.out.println(suset);
		}
	}

}
