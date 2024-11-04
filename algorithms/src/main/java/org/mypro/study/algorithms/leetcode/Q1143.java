package org.mypro.study.algorithms.leetcode;

import java.util.HashSet;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 */
public class Q1143 {

	public int longestCommonSubsequence(String text1, String text2) {

			HashSet<Character> set = new HashSet<Character>(text1.length());
			
			int num =  0;
			for(int i = 0 ; i < text1.length() ; i ++ ) {
				set.add(text1.charAt(i));
			}
			
			for(int i = 0 ; i < text2.length() ; i ++) {
				if(set.contains(text2.charAt(i))) {
					num ++;
				}
			}
			return num;
			
	}

}
