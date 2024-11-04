package org.mypro.study.algorithms.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hew
 *         <p>
 *         给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *         </p>
 * 
 *         <pre>
示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
 *         </pre>
 */
public class Q131 {
	public List<List<String>> partition(String s) {
		List<List<String>> ans = new ArrayList<List<String>>();
		//
		backTrack(ans, new ArrayList<String>(), s, 0);
		//
		return ans;
	}

	
	private void backTrack(List<List<String>> ans ,List<String> track , String s , int start) {
		//递归触底条件
		if(start == s.length()) {
			ans.add(new ArrayList<String>(track));
			return;
		}
		for(int end = start ; end < s.length() ; end ++ ) {
			if(isPalindrome(s, start, end)) { //如果是回文字符串
				track.add(s.substring(start, end + 1));
				//
				backTrack(ans, track, s, end + 1);
				//回溯
				track.remove(track.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s, int start, int end) {

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
