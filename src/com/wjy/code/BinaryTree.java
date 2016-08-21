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
		while((!st.isEmpty())|| (now!=null)){//二者只要有一个就继续循环
			//第一个条件是从儿子返回 第二个是从根加儿子
			while(now!=null){//每克子树 都找它的最左儿子
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
	//后序遍历
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
	//层次遍历 使用一个queue记录本层节点和一个ArrayList记录所有儿子
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
            if(!queue.isEmpty()){
            	tails = BinaryTree.addSons(queue,queue2);
            }else{
            	tails = BinaryTree.addSons(queue2,queue);
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
	 //二叉树查找某个值-递归
	 public  static TreeNode search(TreeNode root,int vv){//递归
		 if(root == null){
			 System.out.println("没有查找到该数");
			 return null;
		 }
		 if(root.val > vv )
			 BinaryTree.search(root.left, vv);
		 else if(root.val < vv)
			 BinaryTree.search(root.right,vv);
		 else{
			 System.out.println("找到该值 "+root.val);
			 return root;
		 }
		 return null;
	 }
	//非递归查找
	 public static TreeNode search2(TreeNode root,int vv){
		 TreeNode tn = root;
		 if(tn ==null){ System.out.println("树为空");}
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
			 System.out.println("未找到该节点");
		 else
			 System.out.println("找到该结点 "+tn.val);
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
			 System.out.println("无该结点 删除失败");
			 return false;
		 }
//		 else{
//			 System.out.println("找到该节点 "+tn.val+" 及其父节点"+tn_p.val);
//		 }
		 if(tn.left == null && tn.right == null){ //无儿子
			 System.out.println("删除无儿子节点");
			 BinaryTree.deleteNull(tn_p, tn);
		 }
		 else if((tn.left == null)^(tn.right == null)){//一个儿子
			 System.out.println("删除有一个儿子节点");
			 if(tn.left!=null)
				 BinaryTree.deleteOne(tn_p,tn.left);
			 else
				 BinaryTree.deleteOne(tn_p, tn.right);
		 }
		 else if(tn.left!=null && tn.right!=null){//两个儿子
			 BinaryTree.deleteTwo(tn_p, tn);
		 }
		 return false;
	 }
	 //寻找后继
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
		 System.out.println("删除有两个儿子节点");
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
	 
	 //输出每层最右 使用双端队列Deque
	 public static void levelLast2(TreeNode root)  
	    {	        //System.out.print(root.val+" ");
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
	 
	 //一下三个函数求取前驱
	 public static TreeNode getPre(TreeNode tn,int v){
		 TreeNode n = tn;
		 if(tn!=null){
			 TreeNode tn_p = null;
			 TreeNode firstRParent = null;
			 
			 while(n!=null){//先定位节点位置 顺路记录其父亲
				 if(n.val == v){
					 break;
				 }
				 tn_p = n;//记录当前节点的父母
				 if(n.val > v){
					 n = n.left;
				 }else{
					 firstRParent = n;//这个是关键 在二分查找最接近的右支
					 n = n.right;
				 }
			 }
			 if(n == null){//如果没有该节点
				 System.out.println("未查找到该节点");
				 return n;
			 }
			 
			 if(tn_p==null){
				 System.out.print(n.val+" 无父亲  ");
			 }else{
				 System.out.print(n.val+" 的父亲 "+ tn_p.val+"  ");
			 }
			 

			 if(n.left!=null){//左子树不为空
				 return getRightNode(n.left);//轻松 返回左子树的最右（包括根左儿子不为空）
			 }
			 if(tn_p==null && n.left ==null)//如果是根而且没有左儿子
				 return null;
			 if(firstRParent==null)//如果是内部节点 但是找不到拐点 即第一个右父亲
				 return null;
			 if(n == tn_p.right)//恰好是父亲的右儿子
				 return tn_p;
			 else{
				 return firstRParent;
			 }
		 }
		 return n;
	 }
	//一下三个函数求取前驱
		 public static TreeNode getNext(TreeNode tn,int v){
			 TreeNode n = tn;
			 if(tn!=null){
				 TreeNode tn_p = null;
				 TreeNode firstLParent = null;
				 
				 while(n!=null){//先定位节点位置 顺路记录其父亲
					 if(n.val == v){
						 break;
					 }
					 tn_p = n;//记录当前节点的父母
					 if(n.val > v){
						 firstLParent = n;
						 n = n.left;
					 }else{
						 n = n.right;
					 }
				 }	 
				 if(n == null){//如果没有该节点
					 System.out.println("未查找到该节点");
					 return n;
				 }
				 if(n.right!=null){//左子树不为空
					 return getLeftNode(n.right);//轻松 返回左子树的最右（包括根左儿子不为空）
				 }
				 if(tn_p==null && n.right ==null)//如果是根而且没有左儿子
					 return null;
				 if(firstLParent==null)//如果是内部节点 但是找不到拐点 即第一个右父亲
					 return null;
				 if(n == tn_p.left)//恰好是父亲的右儿子
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
		System.out.println("————————————————————");
		BinaryTree.search2(r, sear1);
		System.out.println();
		BinaryTree.search2(r, sear2);
		System.out.println();
		BinaryTree.search2(r, sear3);
		System.out.println("————————————————————");
		
		System.out.print("\n前序遍历\t");
		BinaryTree.preOrder(r);
		System.out.print("\n前序遍历（非递归-栈）\t");
		BinaryTree.preOrder_NoDiGui(r);//preOrder_NoDiGui2
		System.out.print("\n中序遍历\t");
		BinaryTree.midOrder(r);
		System.out.print("\n中序遍历（非递归）\t");
		BinaryTree.midOrder_NoDiGui(r);//
		System.out.print("\n后序遍历\t");
		BinaryTree.lastOrder(r);
		System.out.print("\n后序遍历（非递归）\t");
		BinaryTree.lastOrder_NoDiGui(r);
		System.out.print("\n层次遍历\t");
		BinaryTree.levelTraverse(r);
		System.out.print("\n每层最右数(双队列)\n");
		BinaryTree.levelLast(r);
		System.out.print("\n每层最右数(单队列)\n ");
		BinaryTree.levelLast2(r);
		

		System.out.println("\n再次层次遍历");
		BinaryTree.levelTraverse(r);
		TreeNode tn;
		for (int i : nums) {
			tn = BinaryTree.getPre(r, i);
			System.out.print("前驱为 ");
			System.out.print((tn==null)?"null":tn.val);
			System.out.print(" 后继为 ");
			tn = BinaryTree.getNext(r, i);
			System.out.println((tn==null)?"null":tn.val);
		}
		
		//BinaryTree.delete1(11);
		//BinaryTree.delete(0);
		BinaryTree.delete1(0);
	}
}
