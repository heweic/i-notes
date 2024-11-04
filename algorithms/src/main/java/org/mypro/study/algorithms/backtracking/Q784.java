package org.mypro.study.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小全排列
 * 
 * @author hew
 *
 *         <pre>
给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
示例 1：
输入：s = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]
示例 2:
输入: s = "3z4"
输出: ["3z4","3Z4"]
 *         </pre>
 */
public class Q784 {
	public List<String> letterCasePermutation(String s) {
		List<String> ans = new ArrayList<String>();
		//
		backTrack(s.toCharArray(), 0, new StringBuilder(), ans);
		//
		return ans;
	}

	private void backTrack(char[] chars, int index, StringBuilder sb, List<String> rs) {
		//
		if (index == chars.length) {
			rs.add(sb.toString());
			return;
		}
		//
		char c = chars[index];

		if (Character.isLetter(c)) {
			// 小写
			sb.append(Character.toLowerCase(c));
			backTrack(chars, index + 1, sb, rs);
			sb.deleteCharAt(sb.length() - 1);

			// 大写
			sb.append(Character.toUpperCase(c));
			backTrack(chars, index + 1, sb, rs);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			sb.append(c);
			backTrack(chars, index + 1, sb, rs);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
