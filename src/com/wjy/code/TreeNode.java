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
 * �������Ķ��� ���� ���� ��������ǰ�к�ĵݹ� ǰ�к�ķǵݹ� ��α�����
 */
public class TreeNode {//��׼���������
	public int val;
	public TreeNode left,right;
	public int visitedTime;
	
	public TreeNode(int v){
		this.val = v;
		this.left = null;
		this.right = null;
		visitedTime = 0;
	}
	//��ȡ��һ���ַ�	
}
