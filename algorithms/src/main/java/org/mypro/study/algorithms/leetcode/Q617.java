package org.mypro.study.algorithms.leetcode;

public class Q617 {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(null == root1) {
			return root2;
		}
		if(null == root2) {
			return root1;
		}
		TreeNode node = new TreeNode(root1.val + root2.val);
		
		node.left = mergeTrees(root1.left, root2.left);
		node.right = mergeTrees(root1.right, root2.right);
		
		return node;
	}
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