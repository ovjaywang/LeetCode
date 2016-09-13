package com.wjy.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 返回树的层次遍历的数组(正序和zigzag序和自底向上序列)
 * @author Jay Wang-LeetCode 102&103&107
 *
 */
public class Tree_Level_Order_Traversal {
		public static void main(String[] args) {
			
			int nums[] = {1,5,-2,0,3,9,-3,7,-1,4,2,10,11};
			//int nums[] = {3,2,4,1,5};
			for (int i : nums) {
				BinaryTree.insert(i);
			}
			//System.out.println(Tree_Level_Order_Traversal.levelList(BinaryTree.r));//正常层次遍历
			//System.out.println(Tree_Level_Order_Traversal.levelListReverse(BinaryTree.r));//从左到右 从右到左 再从左到右序
			//System.out.println(Tree_Level_Order_Traversal.level_bottom_up_order(BinaryTree.r));//自底向上序
			System.out.println(Tree_Level_Order_Traversal.Min_Depth_of_Shortest_Path(BinaryTree.r));//找最短路径的高度
			System.out.println(Tree_Level_Order_Traversal.minDepth(BinaryTree.r));//上面那题的变态解法
		}
		public static List<List<Integer>> levelList(TreeNode root)  
	    {	
			List<List<Integer>> rs = new ArrayList<List<Integer>>();
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//记录每层尾巴和当前遍历到的结点
	        queue.offer(root);//根入队列
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        List<Integer> listNow = null;
	        while(!queue.isEmpty())//只要队列不为空 则进行找儿子工作
	        {
	        	listNow = new ArrayList<Integer>();
	        	while(!tails.equals(current)){
	        		TreeNode tn = queue.poll();
	        		listNow.add(tn.val);
	        		if(tn.left!=null) queue.offer(tn.left); 
	        		if(tn.right!=null) queue.offer(tn.right);
	        		current = tn;
	        	}
	        	tails = queue.peekLast();
	        	rs.add(listNow);
	        }
	        return rs;
	    }
		
		public static List<List<Integer>> levelListReverse(TreeNode root)  
	    {	
			List<List<Integer>> rs = new ArrayList<List<Integer>>();
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//记录每层尾巴和当前遍历到的结点
	        queue.offer(root);//根入队列
	        boolean isFromLeft = true;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        List<Integer> listNow = null;
	        while(!queue.isEmpty())//只要队列不为空 则进行找儿子工作
	        {
	        	listNow = new ArrayList<Integer>();
	        	while(!tails.equals(current)){
	        		TreeNode tn = queue.poll();
	        		listNow.add(tn.val);
	        		if(tn.left!=null) queue.offer(tn.left); 
	        		if(tn.right!=null) queue.offer(tn.right);
	        		current = tn;
	        	}
	        	tails = queue.peekLast();
	        	if(isFromLeft){
	        		isFromLeft = false;
	        	}else{
	        		int i=0,j= listNow.size()-1;
	        		while(i<j ) {
						int tmp = listNow.get(i);
						listNow.set(i, listNow.get(j));
						listNow.set(j, tmp);
	        			i++;
	        			j--;
					}
	        		isFromLeft = true;
	        	}
	        	rs.add(listNow);
	        }
	        return rs;
	     }
		public static List<List<Integer>> level_bottom_up_order(TreeNode root)  
	    {	
			List<List<Integer>> rs = new ArrayList<List<Integer>>();
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//记录每层尾巴和当前遍历到的结点
	        queue.offer(root);//根入队列
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        List<Integer> listNow = null;
	        while(!queue.isEmpty())//只要队列不为空 则进行找儿子工作
	        {
	        	listNow = new ArrayList<Integer>();
	        	while(!tails.equals(current)){
	        		TreeNode tn = queue.poll();
	        		listNow.add(tn.val);
	        		if(tn.left!=null) queue.offer(tn.left); 
	        		if(tn.right!=null) queue.offer(tn.right);
	        		current = tn;
	        	}
	        	tails = queue.peekLast();
	        	rs.add(listNow);
	        }
	        List<List<Integer>> a = new ArrayList<List<Integer>>();
	        for (int i = rs.size()-1; i >=0; i--) {
				a.add(rs.get(i));
			}
	        return a;
	    }
		public static int Min_Depth_of_Shortest_Path(TreeNode root)  
	    {  
	        int min = Integer.MAX_VALUE;
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//记录每层尾巴和当前遍历到的结点
	        queue.offer(root);//根入队列
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        boolean tag =false;
	        while(!queue.isEmpty())//只要队列不为空 则进行找儿子工作
	        {
	        	while(!tails.equals(current)){
	        		TreeNode tn = queue.poll();
	        		if(tn.left==null && tn.right==null){
	        			min = Math.min(min, level);
	        		}else{
	        			if(tn.left!=null) {
		        			tag = true;
		        			queue.offer(tn.left); 
		        		}
		        		if(tn.right!=null) {
		        			tag = true;
		        			queue.offer(tn.right);
		        		}
	        		}
	        		current = tn;
	        	}
	        	if(tag)
	        		level++;
	        	tails = queue.peekLast();
	        }
	        return min;
	    }
		public static int minDepth(TreeNode root) {
		    if(root == null) return 0;
		    if(root.left == null || root.right == null) 
		    	return 1 + Math.max(Tree_Level_Order_Traversal.minDepth(root.left), minDepth(root.right));
		    return 1 + Math.min(Tree_Level_Order_Traversal.minDepth(root.left), minDepth(root.right));
		    //其实下面这段更容易理解 左为空取右的 右为空取左的
		    //都不为空返回左右的最矮高度+1
//		    if (root == null)	return 0;
//			if (root.left == null)	return minDepth(root.right) + 1;
//			if (root.right == null) return minDepth(root.left) + 1;
//			return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
		    
		}
}