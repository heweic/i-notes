package org.mypro.study.algorithms.binarytree;

/**
 * 二叉树的最大深度
 * 
 * @author hew
 *
 *         <pre>
二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
输入：root = [3,9,20,null,null,15,7]
输出：3
 *         </pre>
 */
public class Q104 {
	public int maxDepth(TreeNode root) {
		if(null == root) {
			return 0;
		}
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
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
