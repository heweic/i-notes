package org.mypro.study.algorithms.binarytree;

/**
 * 二叉树展开为链表
 * 
 * @author hew
 *
 *         <pre>
给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *         </pre>
 */
public class Q114 {
	public void flatten(TreeNode root) {
		// 递归触底
		if (null == root) {
			return;
		}
		// 由上直接左右到底
		flatten(root.left);
		flatten(root.right);
		//
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		//
		TreeNode current = root;
		while (current.right != null) {
			current = current.right;
		}
		current.right = temp;
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
