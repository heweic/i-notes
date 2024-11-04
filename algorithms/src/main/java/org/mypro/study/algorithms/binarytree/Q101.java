package org.mypro.study.algorithms.binarytree;

/**
 * 对称二叉树
 * 
 * @author hew
 *
 *         <pre>
给你一个二叉树的根节点 root ， 检查它是否轴对称。
输入：root = [1,2,2,3,4,4,3]
输出：true
 *         </pre>
 */
public class Q101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMiroot(root.left, root.right);
	}

	private boolean isMiroot(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return (left.val == right.val) && isMiroot(left.left, right.right) && isMiroot(left.right, right.left);
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
