package org.mypro.study.algorithms.recursion;

/**
 * 反转二叉树
 * 
 * @author hew
 *
 *         <pre>
给定一棵二叉树的根节点 root，请左右翻转这棵二叉树，并返回其根节点。
 * 
 *         </pre>
 */
public class Q226 {
	public TreeNode flipTree(TreeNode root) {

		if (null == root) {
			return root;
		}
		//
		TreeNode left = flipTree(root.left);
		TreeNode right = flipTree(root.right);

		root.left = right;
		root.right = left;

		//
		return root;
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
