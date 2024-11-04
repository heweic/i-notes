package org.mypro.study.algorithms.binarytree;

/**
 * 二叉树剪枝
 * 
 * @author hew
 *
 *         <pre>
给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
节点 node 的子树为 node 本身，以及所有 node 的后代。
示例 1:

输入: [1,null,0,0,1]
输出: [1,null,0,null,1] 
解释: 
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。
 *         </pre>
 */
public class LCR47 {
	public TreeNode pruneTree(TreeNode root) {
		if (null == root) {
			return root;
		}
		//
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.val == 0 && root.left == null && root.right == null) {
			return null;
		}
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
