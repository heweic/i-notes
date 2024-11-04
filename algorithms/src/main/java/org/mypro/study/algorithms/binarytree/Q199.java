package org.mypro.study.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 * 
 * @author hew
 *
 *         <pre>
 * 
 *         </pre>
 */
public class Q199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		//
		dfs(root, 0, ans);
		//
		return ans;
	}
	
	private void dfs(TreeNode node, int depth , List<Integer> result) {
		if(null == node) {
			return;
		}
		if(depth == result.size()) {
			result.add(node.val);
		}
		//
		dfs(node.right, depth + 1, result);
		dfs(node.left, depth + 1, result);;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
