package com.wjy.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode {//��׼���������
	public int val;
	public TreeNode left,right;
	
	public TreeNode(int v){
		this.val = v;
		this.left = null;
		this.right = null;
	}
	//��ȡ��һ���ַ�
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
				System.out.println("�����ظ�Ԫ��");
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
	//�������
	public static void lastOrder(TreeNode t) {  
        if(null != t) {  
            lastOrder(t.left);  
            lastOrder(t.right);  
            System.out.print(t.val + " ");  
        }  
    } 
	//��α���
	public static void levelTraverse(TreeNode root)  
    {  
        System.out.print(root.val+" | ");
        Queue<TreeNode> queue=new LinkedList<TreeNode>();  
        queue.offer(root);//�������
        int level=1;
        while(!queue.isEmpty())//ֻҪ���в�Ϊ��
        {  
            List<TreeNode> list=new ArrayList<TreeNode>();  
            while(!queue.isEmpty())  
            {  
                list.add(queue.poll());//���ϴα������Ķ��Ӽ��뵽����
            }  
            boolean tag=false;  
            for(int i=0;i<list.size();i++)//ÿ�α���һ���ϲ�ڵ� �����ж��� ����� ���������  
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
            if(tag)//ֻҪ��¼��һ������ ���һ��
            {  
                level++; 
                System.out.print(" | ");
            }  
        }  
        System.out.println("��������"+level+"��");  
    }
	//���ÿ������һ�� ʹ��˫����
	public static void levelLast(TreeNode root)  
    {  
        //System.out.print(root.val+" ");
        Queue<TreeNode> queue=new LinkedList<TreeNode>();//��һ�����д洢�ϲ�
        Queue<TreeNode> queue2=new LinkedList<TreeNode>();
        queue.offer(root);//�������
        int level=1;
        TreeNode tails= root;
        System.out.println("��"+level+"��   ĩλ ��"+ tails.val);   
        while(!(queue.isEmpty()&&queue2.isEmpty()))//ֻҪ���в�Ϊ�� ������Ҷ��ӹ���
        {  
            boolean tag=false;
            if(!queue.isEmpty()){
            	tails = TreeNode.addSons(queue,queue2);
            }else{
            	tails = TreeNode.addSons(queue2,queue);
            } 
            if(tails!=null)//ֻҪ��¼��һ������ ���һ��
            {  
                level++;
                System.out.println("��"+level+"��   ĩλ ��"+ tails.val);   
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
	 //���ÿ������ ʹ��˫�˶���Deque
	 public static void levelLast2(TreeNode root)  
	    {  
	        //System.out.print(root.val+" ");
		 	Deque<TreeNode> queue=new LinkedList<TreeNode>();//��¼ÿ��β�ͺ͵�ǰ�������Ľ��
	        queue.offer(root);//�������
	        int level=1;
	        TreeNode tails= root;
	        TreeNode current  =null;
	        System.out.println("��"+level+"��   ĩλ ��"+ tails.val);   
	        while(!queue.isEmpty())//ֻҪ���в�Ϊ�� ������Ҷ��ӹ���
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
	            	System.out.println("��"+level+"��   ĩλ ��"+ tails.val);
	            }
	        }  
	    }
	//�ֶ�����ڵ�����
//	public static void main(String[] args) {
//		System.out.println("���������");
//		TreeNode root = getInt();
//		System.out.println("������ڵ㣺");
//		TreeNode aNode = getInt();
//		while (aNode.val!=-10000) {
//			if(TreeNode.insert(root,aNode)){
//				System.out.println("�ɹ�����:"+aNode.val);
//			}else {
//				System.out.println("����ʧ��");
//			}
//			System.out.println("������ڵ㣺");
//			aNode = getInt();
//		}
//		System.out.print("ǰ�����   ");
//		TreeNode.preOrder(root);
//		System.out.print("�������   ");
//		TreeNode.midOrder(root);
//		System.out.print("�������   ");
//		TreeNode.lastOrder(root);
//		System.out.println("��α���");
//		TreeNode.levelTraverse(root);
//	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1); 
		int nums[] = {5,-2,0,3,9,-3,-1,4,2,10,11};
		for (int i : nums) {
			TreeNode.insert(root, new TreeNode(i));
		}
		System.out.print("\nǰ�����   ");
		TreeNode.preOrder(root);
		System.out.print("\n�������   ");
		TreeNode.midOrder(root);
		System.out.print("\n�������   ");
		TreeNode.lastOrder(root);
		System.out.print("\n��α���   ");
		TreeNode.levelTraverse(root);
		System.out.print("\nÿ��������(˫����)\n");
		TreeNode.levelLast(root);
		System.out.print("\nÿ��������(������)\n ");
		TreeNode.levelLast2(root);
	}
	
	
	
	
}
