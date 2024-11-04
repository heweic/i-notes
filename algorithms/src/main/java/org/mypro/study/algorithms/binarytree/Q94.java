package org.mypro.study.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 
 * @author hew
 *
 *         <pre>
 * 
 * 
 *         </pre>
 */
public class Q94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();

		inorder(root, ans);

		return ans;
	}

	private void inorder(TreeNode node, List<Integer> result) {
		if (null == node) {
			return;
		}
		inorder(node.left, result);
		result.add(node.val);
		inorder(node.right, result);
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
