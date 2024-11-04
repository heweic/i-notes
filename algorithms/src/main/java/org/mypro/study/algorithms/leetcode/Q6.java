package org.mypro.study.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 *
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Q6 {

	public static void main(String[] args) {
		// 14 + 4 - 1 / 4
		System.out.println("PAYPALISHIRING");
		System.out.println("PAHNAPLSIIGYIR");
		System.out.println(new Q6().convert("ABCD", 2));
	}

	/**
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		 if (numRows == 1) {
	            return s;
	        }
	        List<StringBuilder> rows = new ArrayList<>();
	        for (int row = 0; row < numRows; row++) {
	            rows.add(new StringBuilder());
	        }
	        int i = 0;
	        int flag = -1;
	        for (char c : s.toCharArray()) {
	            rows.get(i).append(c);
	            if (i == 0 || i == numRows - 1) {
	                flag = -flag;
	            }
	            i += flag;
	        }
	        StringBuilder sb = new StringBuilder();
	        for (StringBuilder row : rows) {
	            sb.append(row);
	        }
	        return sb.toString();
	}
}
