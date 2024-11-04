package org.mypro.study.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 
 * @author hew
 *
 *         <pre>
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：
输入：n = 1
输出：["()"]
 *         </pre>
 */
public class Q22 {
	public List<String> generateParenthesis(int n) {

		//
		List<String> ans = new ArrayList<String>();
		//
		backTrack(ans, new StringBuilder(), 0, 0, n);
		//
		return ans;
	}

	private void backTrack(List<String> ans, StringBuilder sb, int left, int right, int n) {
		//
		if (left == n && right == n) {
			ans.add(sb.toString());
			return;
		}
		//
		if (left < n) {
			sb.append("(");
			backTrack(ans, sb, left + 1, right, n);
			//
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			backTrack(ans, sb, left, right + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
