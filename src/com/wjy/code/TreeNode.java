package com.wjy.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode {//标准二叉查找树
	public int val;
	public TreeNode left,right;
	
	public TreeNode(int v){
		this.val = v;
		this.left = null;
		this.right = null;
	}
	//获取下一个字符
	public static TreeNode getInt(){
		Scanner sc = new Scanner(System.in);
		return new TreeNode(sc.nextInt());
	}
	
	public static boolean insert(TreeNode root,TreeNode a){
		if(root == null || a== null) return false;
		TreeNode n = root;
		while(true){
			if((a.val < n.val)){
				if(n.left!=null){
					n = n.left;
				}else {
					n.left = a;
					return true;
				}
			}else if(a.val > n.val){
				if(n.right!=null){
					n=n.right;
				}else{
					n.right = a;
					return true;
				}
			}else if(a.val == n.val){
				System.out.println("插入重复元素");
				return false;
			}
		}
	}
	
	public static void preOrder(TreeNode t) {  
        if(null != t) {  
            System.out.print(t.val + " ");  
            preOrder(t.left);  
            preOrder(t.right);  
        }  
    }  
	public static void midOrder(TreeNode t) {  
        if(null != t) {  
        	midOrder(t.left);  
            System.out.print(t.val + " ");  
            midOrder(t.right);  
        }  
    }  
	//后序遍历
	public static void lastOrder(TreeNode t) {  
        if(null != t) {  
            lastOrder(t.left);  
            lastOrder(t.right);  
            System.out.print(t.val + " ");  
        }  
    } 
	//层次遍历
	public static void levelTraverse(TreeNode root)  
    {  
        System.out.print(root.val+" | ");
        Queue<TreeNode> queue=new LinkedList<TreeNode>();  
        queue.offer(root);//根入队列
        int level=1;
        while(!queue.isEmpty())//只要队列不为空
        {  
            List<TreeNode> list=new ArrayList<TreeNode>();  
            while(!queue.isEmpty())  
            {  
                list.add(queue.poll());//把上次遍历到的儿子加入到队列
            }  
            boolean tag=false;  
            for(int i=0;i<list.size();i++)//每次遍历一个上层节点 若果有儿子 则输出 并加入队列  
            {  
               if(list.get(i).left!=null)  
               {  
                System.out.print(list.get(i).left.val+" ");  
                queue.offer(list.get(i).left);  
                tag=true;  
               }  
               if(list.get(i).right!=null)  
               {  
                System.out.print(list.get(i).right.val+" ");  
                queue.offer(list.get(i).right);  
                tag=true;  
               }  
            }  
            if(tag)//只要记录了一个儿子 则加一层
            {  
                level++; 
                System.out.print(" | ");
            }  
        }  
        System.out.println("二叉树共"+level+"层");  
    }
	//输出每层最右一个 使用双队列
	public static void levelLast(TreeNode root)  
    {  
        //System.out.print(root.val+" ");
        Queue<TreeNode> queue=new LinkedList<TreeNode>();//第一个队列存储上层
        Queue<TreeNode> queue2=new LinkedList<TreeNode>();
        queue.offer(root);//根入队列
        int level=1;
        TreeNode tails= root;
        System.out.println("第"+level+"层   末位 ："+ tails.val);   
        while(!(queue.isEmpty()&&queue2.isEmpty()))//只要队列不为空 则进行找儿子工作
        {  
            boolean tag=false;
            if(!queue.isEmpty()){
            	tails = TreeNode.addSons(queue,queue2);
            }else{
            	tails = TreeNode.addSons(queue2,queue);
            } 
            if(tails!=null)//只要记录了一个儿子 则加一层
            {  
                level++;
                System.out.println("第"+level+"层   末位 ："+ tails.val);   
            }  
        }  
    }
	 static TreeNode addSons(Queue<TreeNode> q1,Queue<TreeNode> q2){
		if(q1.isEmpty()) return null;
		TreeNode tails=null;
		TreeNode tn ;
		while (!q1.isEmpty()) {
			tn = q1.poll();
			if(tn.left!=null)  
            {  
	             q2.offer(tn.left);
	             tails = tn.left;
            }  
            if(tn.right!=null)  
            {  
                q2.offer(tn.right);
	            tails = tn.right;
            }  	
		}
		return tails;
	}
	 //输出每层最右 使用双端队列Deque
	 public static void levelLast2(TreeNode root)  
	    {  
	        //System.out.print(root.val+" ");
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//记录每层尾巴和当前遍历到的结点
	        queue.offer(root);//根入队列
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        System.out.println("第"+level+"层   末位 ："+ tails.val);   
	        while(!queue.isEmpty())//只要队列不为空 则进行找儿子工作
	        {  	            
	        	while(!tails.equals(current)){
	        		TreeNode tn = queue.poll();
	        		if(tn.left!=null) queue.offer(tn.left); 
	        		if(tn.right!=null) queue.offer(tn.right);
	        		current = tn;
	        	}
	            tails = queue.peekLast();
	            if(tails!=null){
	            	level ++;
	            	System.out.println("第"+level+"层   末位 ："+ tails.val);
	            }
	        }  
	    }
	//手动输入节点如下
//	public static void main(String[] args) {
//		System.out.println("请输入根：");
//		TreeNode root = getInt();
//		System.out.println("请输入节点：");
//		TreeNode aNode = getInt();
//		while (aNode.val!=-10000) {
//			if(TreeNode.insert(root,aNode)){
//				System.out.println("成功插入:"+aNode.val);
//			}else {
//				System.out.println("插入失败");
//			}
//			System.out.println("请输入节点：");
//			aNode = getInt();
//		}
//		System.out.print("前序遍历   ");
//		TreeNode.preOrder(root);
//		System.out.print("中序遍历   ");
//		TreeNode.midOrder(root);
//		System.out.print("后序遍历   ");
//		TreeNode.lastOrder(root);
//		System.out.println("层次遍历");
//		TreeNode.levelTraverse(root);
//	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1); 
		int nums[] = {5,-2,0,3,9,-3,-1,4,2,10,11};
		for (int i : nums) {
			TreeNode.insert(root, new TreeNode(i));
		}
		System.out.print("\n前序遍历   ");
		TreeNode.preOrder(root);
		System.out.print("\n中序遍历   ");
		TreeNode.midOrder(root);
		System.out.print("\n后序遍历   ");
		TreeNode.lastOrder(root);
		System.out.print("\n层次遍历   ");
		TreeNode.levelTraverse(root);
		System.out.print("\n每层最右数(双队列)\n");
		TreeNode.levelLast(root);
		System.out.print("\n每层最右数(单队列)\n ");
		TreeNode.levelLast2(root);
	}
	
	
	
	
}
