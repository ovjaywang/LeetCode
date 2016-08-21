package com.wjy.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	private static TreeNode r = null;
	
	public static TreeNode getInt(){
		Scanner sc = new Scanner(System.in);
		return new TreeNode(sc.nextInt());
	}
	
	public static boolean insert(int a){
		if(r == null ){
			r = new TreeNode(a);
			return true;
		}
		TreeNode n = r;
		while(true){
			if((a < n.val)){
				if(n.left!=null){
					n = n.left;
				}else {
					n.left = new TreeNode(a);
					return true;
				}
			}else if(a > n.val){
				if(n.right!=null){
					n=n.right;
				}else{
					n.right = new TreeNode(a);
					return true;
				}
			}else if(a == n.val){
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
	public static void preOrder_NoDiGui(TreeNode t){
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode now = t;
		st.add(t);
		while(!st.empty()){
			System.out.print(now.val+" ");
			if(now.right!=null){
				st.add(now.right);
			}
			if(now.left!=null){
				st.add(now.left);
			}
			now = st.pop();
		}
	}

	
	public static void midOrder(TreeNode t) {  
        if(null != t) {  
        	midOrder(t.left);  
            System.out.print(t.val + " ");  
            midOrder(t.right);  
        }  
    }
	public static void midOrder_NoDiGui(TreeNode t){
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode now = t;
		//st.add(now);
		while((!st.isEmpty())|| (now!=null)){//����ֻҪ��һ���ͼ���ѭ��
			//��һ�������ǴӶ��ӷ��� �ڶ����ǴӸ��Ӷ���
			while(now!=null){//ÿ������ ���������������
				st.add(now);
				now = now.left;
			}
			if(!st.isEmpty()){
				now = st.pop();
				System.out.print(now.val+" ");
				now = now.right;
			}
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
	public static void lastOrder_NoDiGui(TreeNode t){
		TreeNode now;
		Stack<TreeNode> st=  new Stack<TreeNode>();
		st.add(t);
		while (!st.isEmpty()) {
			now = st.peek();
			if(now.visitedTime == 2){
				now = st.pop();
				System.out.print(now.val+" ");
				continue;
			}
			if(now.visitedTime==0){
				now.visitedTime++;
				if(now.left !=null){
					st.add(now.left);
					continue;
				}

			}
			if(now.visitedTime==1){
				now.visitedTime++;
				if(now.right !=null){
					st.add(now.right);
					continue;
				}
			}
		}
	}
	//��α��� ʹ��һ��queue��¼����ڵ��һ��ArrayList��¼���ж���
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
            if(!queue.isEmpty()){
            	tails = BinaryTree.addSons(queue,queue2);
            }else{
            	tails = BinaryTree.addSons(queue2,queue);
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
	 //����������ĳ��ֵ-�ݹ�
	 public  static TreeNode search(TreeNode root,int vv){//�ݹ�
		 if(root == null){
			 System.out.println("û�в��ҵ�����");
			 return null;
		 }
		 if(root.val > vv )
			 BinaryTree.search(root.left, vv);
		 else if(root.val < vv)
			 BinaryTree.search(root.right,vv);
		 else{
			 System.out.println("�ҵ���ֵ "+root.val);
			 return root;
		 }
		 return null;
	 }
	//�ǵݹ����
	 public static TreeNode search2(TreeNode root,int vv){
		 TreeNode tn = root;
		 if(tn ==null){ System.out.println("��Ϊ��");}
		 while(tn!=null){
			 if(vv<tn.val){
				 tn = tn.left;
			 }
			 else if(vv>tn.val){
				 tn = tn.right;
			 }else{
				 break;
			 }
		 }
		 if(tn==null)
			 System.out.println("δ�ҵ��ýڵ�");
		 else
			 System.out.println("�ҵ��ý�� "+tn.val);
		 return tn;
	 }
	 public static boolean delete1(int vv){
		 if(r == null) return false;
		 TreeNode tn = r;
		 TreeNode tn_p = null;
		 while(tn!=null){
			 if(tn.val == vv){
				 break;
			 }
			 tn_p = tn;
			 if(vv < tn.val){
				 tn = tn.left;
			 }else if(vv > tn.val){
				 tn = tn.right;
			 }
		 }
		 if(tn == null){
			 System.out.println("�޸ý�� ɾ��ʧ��");
			 return false;
		 }
//		 else{
//			 System.out.println("�ҵ��ýڵ� "+tn.val+" ���丸�ڵ�"+tn_p.val);
//		 }
		 if(tn.left == null && tn.right == null){ //�޶���
			 System.out.println("ɾ���޶��ӽڵ�");
			 BinaryTree.deleteNull(tn_p, tn);
		 }
		 else if((tn.left == null)^(tn.right == null)){//һ������
			 System.out.println("ɾ����һ�����ӽڵ�");
			 if(tn.left!=null)
				 BinaryTree.deleteOne(tn_p,tn.left);
			 else
				 BinaryTree.deleteOne(tn_p, tn.right);
		 }
		 else if(tn.left!=null && tn.right!=null){//��������
			 BinaryTree.deleteTwo(tn_p, tn);
		 }
		 return false;
	 }
	 //Ѱ�Һ��
//	 private static TreeNode findNextOne(TreeNode n){
//		 
//	 }
	 private static void deleteNull(TreeNode p_node,TreeNode node){
		 if(p_node == null ) node = null;
		 if(node.val < p_node.val){
			 p_node.left = null;
		 }else
			 p_node.right = null;
	 }
	 private static void deleteOne(TreeNode p_node,TreeNode son){
		 if(p_node == null) r = son;
		 if(son.val < p_node.val){
			 p_node.left = son;
		 }else{
			 p_node.right = son;
		 }
	 }
	 private static void deleteTwo(TreeNode p_node,TreeNode tn){
		 System.out.println("ɾ�����������ӽڵ�");
		 TreeNode r_most_l,r_most_l_p;
		 r_most_l_p = tn;
		 r_most_l = tn.right;
		 while(r_most_l.left!=null){
			 r_most_l_p = r_most_l;
			 r_most_l = r_most_l.left;
		 }
		 if(r_most_l.left==null && r_most_l.right==null){
			 BinaryTree.deleteNull(r_most_l_p, r_most_l);
		 }
		 if(r_most_l.left==null ^ r_most_l.right==null){
			 if(r_most_l.left!=null){
				 BinaryTree.deleteOne(r_most_l_p, r_most_l.left);
			 }
			 else if(r_most_l.right!=null){
				 BinaryTree.deleteOne(r_most_l_p, r_most_l.right);
			 }
		 }
		 if(p_node == null){
			 r_most_l.left = r.left ;
			 r_most_l.right = r.right;
			 r = r_most_l;
		 }else{
			 if(tn.val < p_node.val)
			 {
				 p_node.left = r_most_l;
			 }
			 else
				 p_node.right = r_most_l;
		 }
		 
		 r_most_l.left =tn.left;
		 r_most_l.right = tn.right;
	 }
	 
	 //���ÿ������ ʹ��˫�˶���Deque
	 public static void levelLast2(TreeNode root)  
	    {	        //System.out.print(root.val+" ");
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
	 
	 //һ������������ȡǰ��
	 public static TreeNode getPre(TreeNode tn,int v){
		 TreeNode n = tn;
		 if(tn!=null){
			 TreeNode tn_p = null;
			 TreeNode firstRParent = null;
			 
			 while(n!=null){//�ȶ�λ�ڵ�λ�� ˳·��¼�丸��
				 if(n.val == v){
					 break;
				 }
				 tn_p = n;//��¼��ǰ�ڵ�ĸ�ĸ
				 if(n.val > v){
					 n = n.left;
				 }else{
					 firstRParent = n;//����ǹؼ� �ڶ��ֲ�����ӽ�����֧
					 n = n.right;
				 }
			 }
			 if(n == null){//���û�иýڵ�
				 System.out.println("δ���ҵ��ýڵ�");
				 return n;
			 }
			 
			 if(tn_p==null){
				 System.out.print(n.val+" �޸���  ");
			 }else{
				 System.out.print(n.val+" �ĸ��� "+ tn_p.val+"  ");
			 }
			 

			 if(n.left!=null){//��������Ϊ��
				 return getRightNode(n.left);//���� ���������������ң�����������Ӳ�Ϊ�գ�
			 }
			 if(tn_p==null && n.left ==null)//����Ǹ�����û�������
				 return null;
			 if(firstRParent==null)//������ڲ��ڵ� �����Ҳ����յ� ����һ���Ҹ���
				 return null;
			 if(n == tn_p.right)//ǡ���Ǹ��׵��Ҷ���
				 return tn_p;
			 else{
				 return firstRParent;
			 }
		 }
		 return n;
	 }
	//һ������������ȡǰ��
		 public static TreeNode getNext(TreeNode tn,int v){
			 TreeNode n = tn;
			 if(tn!=null){
				 TreeNode tn_p = null;
				 TreeNode firstLParent = null;
				 
				 while(n!=null){//�ȶ�λ�ڵ�λ�� ˳·��¼�丸��
					 if(n.val == v){
						 break;
					 }
					 tn_p = n;//��¼��ǰ�ڵ�ĸ�ĸ
					 if(n.val > v){
						 firstLParent = n;
						 n = n.left;
					 }else{
						 n = n.right;
					 }
				 }	 
				 if(n == null){//���û�иýڵ�
					 System.out.println("δ���ҵ��ýڵ�");
					 return n;
				 }
				 if(n.right!=null){//��������Ϊ��
					 return getLeftNode(n.right);//���� ���������������ң�����������Ӳ�Ϊ�գ�
				 }
				 if(tn_p==null && n.right ==null)//����Ǹ�����û�������
					 return null;
				 if(firstLParent==null)//������ڲ��ڵ� �����Ҳ����յ� ����һ���Ҹ���
					 return null;
				 if(n == tn_p.left)//ǡ���Ǹ��׵��Ҷ���
					 return tn_p;
				 else{
					 return firstLParent;
				 }
			 }
			 return n;
		 }
	 public static TreeNode getRightNode(TreeNode tn){
		 if(tn==null) return null;
		 while(tn.right!=null)
			 tn=  tn.right;
		 return tn;
	 }
	 public static TreeNode getLeftNode(TreeNode tn){
		 if(tn == null)
			 return null;
		 while(tn.left!=null){
			 tn = tn.left;
		 }
		 return tn;
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
		BinaryTree bt = new BinaryTree();
		int nums[] = {1,5,-2,0,3,9,-3,7,-1,4,2,10,11};
		for (int i : nums) {
			BinaryTree.insert(i);
		}
		int sear1= 4;
		int sear2 = -5;
		int sear3 = 10;
		BinaryTree.search(r, sear1);
		System.out.println();
		BinaryTree.search(r, sear2);
		System.out.println();
		BinaryTree.search(r, sear3);
		System.out.println("����������������������������������������");
		BinaryTree.search2(r, sear1);
		System.out.println();
		BinaryTree.search2(r, sear2);
		System.out.println();
		BinaryTree.search2(r, sear3);
		System.out.println("����������������������������������������");
		
		System.out.print("\nǰ�����\t");
		BinaryTree.preOrder(r);
		System.out.print("\nǰ��������ǵݹ�-ջ��\t");
		BinaryTree.preOrder_NoDiGui(r);//preOrder_NoDiGui2
		System.out.print("\n�������\t");
		BinaryTree.midOrder(r);
		System.out.print("\n����������ǵݹ飩\t");
		BinaryTree.midOrder_NoDiGui(r);//
		System.out.print("\n�������\t");
		BinaryTree.lastOrder(r);
		System.out.print("\n����������ǵݹ飩\t");
		BinaryTree.lastOrder_NoDiGui(r);
		System.out.print("\n��α���\t");
		BinaryTree.levelTraverse(r);
		System.out.print("\nÿ��������(˫����)\n");
		BinaryTree.levelLast(r);
		System.out.print("\nÿ��������(������)\n ");
		BinaryTree.levelLast2(r);
		

		System.out.println("\n�ٴβ�α���");
		BinaryTree.levelTraverse(r);
		TreeNode tn;
		for (int i : nums) {
			tn = BinaryTree.getPre(r, i);
			System.out.print("ǰ��Ϊ ");
			System.out.print((tn==null)?"null":tn.val);
			System.out.print(" ���Ϊ ");
			tn = BinaryTree.getNext(r, i);
			System.out.println((tn==null)?"null":tn.val);
		}
		
		//BinaryTree.delete1(11);
		//BinaryTree.delete(0);
		BinaryTree.delete1(0);
	}
}
