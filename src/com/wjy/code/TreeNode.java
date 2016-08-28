package com.wjy.code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * @author Jay Wang
 * 二叉树节点的定义 多加了一个VisitedTime来记录访问次数 用于非递归后续遍历
 */
public class TreeNode {//标准二叉查找树
	public int val;
	public TreeNode left,right;
	public int visitedTime;
	
	public TreeNode(int v){
		this.val = v;
		this.left = null;
		this.right = null;
		visitedTime = 0;
	}
	//获取下一个字符	
}
