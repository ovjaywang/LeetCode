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
 * 二叉树的定义 插入 查找 及遍历（前中后的递归 前中后的非递归 层次遍历）
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
