package org.mypro.study.algorithms.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 
 * @author hew
 *
 *         <pre>
 * 
 *         </pre>
 */
public class Q102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		//
		if(null == root) {
			return new ArrayList<List<Integer>>();
		}
		Queue<TreeNode> queue = new LinkedList<Q102.TreeNode>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int leveSize = queue.size();
			
			List<Integer> curr = new ArrayList<Integer>();
			
			for(int i = 0; i < leveSize; i ++ ) {
				TreeNode node = queue.poll();
				curr.add(node.val);
				//
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(curr);
		}
		
		//
		
		return result;
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
