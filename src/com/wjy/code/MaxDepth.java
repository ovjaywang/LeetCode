package com.wjy.code;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepth {
	 public int maxDepth(TreeNode root) {
		 if (root == null)
       	  	return 0;
       else {
       	  	int left = maxDepth(root.left);
       	  	int right = maxDepth(root.right);
       	  	return 1 + Math.max(left, right);
       	 }
	    }
	 public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	  }
	// 获取最大宽度
	    public static int getMaxWidth(TreeNode root) {
	        if (root == null)
	            return 0;
	        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
	        int maxWitdth = 1; // 最大宽度
	        queue.add(root); // 入队

	        while (true) {
	            int len = queue.size(); // 当前层的节点个数
	            if (len == 0)
	                break;
	            while (len > 0) {// 如果当前层，还有节点
	                TreeNode t = queue.poll();
	                len--;
	                if (t.left != null)
	                    queue.add(t.left); // 下一层节点入队
	                if (t.right != null)
	                    queue.add(t.right);// 下一层节点入队
	            }
	            maxWitdth = Math.max(maxWitdth, queue.size());
	        }
	        return maxWitdth;
	    }
	 public static void main(String[] args) {
		MaxDepth md =new MaxDepth();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.right = node6;
		node1.left = node2;
		node2.right = node3;
		node2.left = node7;
		node3.left = node4;
		node3.right = node5;
		System.out.println(md.maxDepth(node1));
		System.out.println(md.getMaxWidth(node1));
	}
}
