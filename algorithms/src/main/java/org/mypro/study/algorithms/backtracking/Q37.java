package org.mypro.study.algorithms.backtracking;

/**
 * 解数独
 * 
 * @author hew
 *
 *         <pre>
数独的解法需 遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。
 *         </pre>
 */
public class Q37 {
	public void solveSudoku(char[][] board) {
		backTrack(board);
	}

	private boolean backTrack(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (isValid(board, i, j, num)) {
							board[i][j] = num;
							// 超级操作
							if (backTrack(board)) {
								return true;
							}
							//
							board[i][j] = '.';

						}
					}
					return false;
				}
			}

		}
		//
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char num) {
		for (int i = 0; i < 9; i++) {
			// 检查行列是否重复
			if (board[row][i] == num || board[i][col] == num) {
				return false;
			}
			// 检查3X3是否有重复
			int boxRow = (row / 3) * 3 + i / 3;
			int boxCol = (col / 3) * 3 + i % 3;
			if (board[boxRow][boxCol] == num) {
				return false;
			}
		}
		return true;
	}
}
