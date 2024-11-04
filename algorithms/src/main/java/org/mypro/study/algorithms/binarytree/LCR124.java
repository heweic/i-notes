package org.mypro.study.algorithms.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 推理二叉树
 * 
 * @author hew
 *
 *         <pre>
某二叉树的先序遍历结果记录于整数数组 preorder，它的中序遍历结果记录于整数数组 inorder。请根据 preorder 和 inorder 的提示构造出这棵二叉树并返回其根节点。
注意：preorder 和 inorder 中均不含重复数字。
 *         </pre>
 */
public class LCR124 {
	
	private Map<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();
	
	private int preIndex = 0;
	
	public TreeNode deduceTree(int[] preorder, int[] inorder) {

		for(int i = 0 ; i < inorder.length ; i ++) {
			inorderIndex.put(inorder[i], i);
		}
		//
		return build(preorder, 0, inorder.length - 1);
	}

	
	private TreeNode build(int[] preorder , int instart , int inend) {
		if(instart > inend) {
			return null;
		}
		int rootVal = preorder[preIndex ++];
		TreeNode root = new TreeNode(rootVal);
		
		int inIndex = inorderIndex.get(root.val);
		
		//
		root.left = build(preorder, instart, inIndex - 1);
		root.right = build(preorder, inIndex + 1, inend);
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
