package org.mypro.study.algorithms.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N 皇后
 * 
 * @author hew
 *
 *         <pre>
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *         </pre>
 */
public class Q51 {

	public List<List<String>> solveNQueens(int n) {
		//
		List<List<String>> ans = new ArrayList<List<String>>();
		//
		Set<Integer> col = new HashSet<Integer>();
		Set<Integer> di = new HashSet<Integer>();
		Set<Integer> di2 = new HashSet<Integer>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		backTrack(ans, board, n, 0, col, di, di2);
		//
		return ans;
	}

	//
	private void backTrack(List<List<String>> ans, char[][] board, int n, int row, Set<Integer> col, Set<Integer> di,
			Set<Integer> di2) {
		// 递归触底条件
		if (row == n) {
			ans.add(toList(board));
			return;
		}
		//
		for (int j = 0; j < n; j++) {
			// 检查行，列，对角是否有冲突
			if (col.contains(j) || di.contains(row - j) || di2.contains(row +  j)) {
				continue;
			}
			// 放置
			board[row][j] = 'Q';
			col.add(j);
			di.add(row - j);
			di2.add(row + j);
			// 递归
			backTrack(ans, board, n, row + 1, col, di, di2);
			// 回溯
			board[row][j] = '.';
			col.remove(j);
			di.remove(row - j);
			di2.remove(row + j);
		}
	}

	//
	private List<String> toList(char[][] board) {
		List<String> list = new ArrayList<String>();
		//
		for (int i = 0; i < board.length; i++) {
			list.add(new String(board[i]));
		}

		//
		return list;
	}
}
