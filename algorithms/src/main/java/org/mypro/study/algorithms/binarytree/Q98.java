package org.mypro.study.algorithms.binarytree;

/**
 * 验证二叉搜索树
 * 
 * @author hew
 *
 *         <pre>
 * 
 *         </pre>
 */
public class Q98 {
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
    }

	public boolean isValidBST(TreeNode root , Integer lower , Integer upper) {
		if(null == root) {
			return true;
		}
		int val = root.val;
		if(lower != null && val <= lower) {
			return false;
		}
		if(upper != null && val >= upper) {
			return false;
		}
		
		if(!isValidBST(root.left, lower, val)) {
			return false;
		}
		if(!isValidBST(root.right, val, upper)) {
			return false;
		}
		return true;
		
		
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
