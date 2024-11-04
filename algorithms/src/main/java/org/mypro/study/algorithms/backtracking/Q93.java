package org.mypro.study.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hew
 *         <p>
 *         复原 IP 地址
 *         </p>
 * 
 *         <pre>
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

 

示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *         </pre>
 */
public class Q93 {
	public List<String> restoreIpAddresses(String s) {

		List<String> ans = new ArrayList<String>();
		//
		backTreack(ans, new ArrayList<String>(), s, 0);
		//
		return ans;

	}

	private void backTreack(List<String> ans, List<String> track, String s, int start) {
		// 触底条件
		if (track.size() == 4) {
			if (start == s.length()) {
				ans.add(String.join(".", track));
			}
			//
			return;
		}
		// 微操作嵌套超级操作
		// 分割三个长度
		for (int len = 1; len <= 3; len++) {
			// 如果长度不足
			if (start + len > s.length()) {
				break;
			}
			// 裁剪
			String segment = s.substring(start, start + len);

			// 如果是有效IP
			if (isValid(segment)) {
				track.add(segment);
				//
				backTreack(ans, track, s, start + len);
				//
				track.remove(track.size() - 1);
			}

		}
	}

	private boolean isValid(String segment) {
		if (segment.length() > 1 && segment.startsWith("0")) {
			return false;
		}
		int value = Integer.parseInt(segment);

		return value >= 0 && value <= 255;
	}
}
