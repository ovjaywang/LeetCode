package com.wjy.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * �������Ĳ�α���������(�����zigzag����Ե���������)
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
			//System.out.println(Tree_Level_Order_Traversal.levelList(BinaryTree.r));//������α���
			//System.out.println(Tree_Level_Order_Traversal.levelListReverse(BinaryTree.r));//������ ���ҵ��� �ٴ�������
			//System.out.println(Tree_Level_Order_Traversal.level_bottom_up_order(BinaryTree.r));//�Ե�������
			System.out.println(Tree_Level_Order_Traversal.Min_Depth_of_Shortest_Path(BinaryTree.r));//�����·���ĸ߶�
			System.out.println(Tree_Level_Order_Traversal.minDepth(BinaryTree.r));//��������ı�̬�ⷨ
		}
		public static List<List<Integer>> levelList(TreeNode root)  
	    {	
			List<List<Integer>> rs = new ArrayList<List<Integer>>();
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//��¼ÿ��β�ͺ͵�ǰ�������Ľ��
	        queue.offer(root);//�������
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        List<Integer> listNow = null;
	        while(!queue.isEmpty())//ֻҪ���в�Ϊ�� ������Ҷ��ӹ���
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
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//��¼ÿ��β�ͺ͵�ǰ�������Ľ��
	        queue.offer(root);//�������
	        boolean isFromLeft = true;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        List<Integer> listNow = null;
	        while(!queue.isEmpty())//ֻҪ���в�Ϊ�� ������Ҷ��ӹ���
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
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//��¼ÿ��β�ͺ͵�ǰ�������Ľ��
	        queue.offer(root);//�������
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        List<Integer> listNow = null;
	        while(!queue.isEmpty())//ֻҪ���в�Ϊ�� ������Ҷ��ӹ���
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
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//��¼ÿ��β�ͺ͵�ǰ�������Ľ��
	        queue.offer(root);//�������
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        boolean tag =false;
	        while(!queue.isEmpty())//ֻҪ���в�Ϊ�� ������Ҷ��ӹ���
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
		    //��ʵ������θ�������� ��Ϊ��ȡ�ҵ� ��Ϊ��ȡ���
		    //����Ϊ�շ������ҵ���߶�+1
//		    if (root == null)	return 0;
//			if (root.left == null)	return minDepth(root.right) + 1;
//			if (root.right == null) return minDepth(root.left) + 1;
//			return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
		    
		}
}