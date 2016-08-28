package com.wjy.code;
/**
 * �������ķ�ת-226
 * @author Jay Wang
 *
 */
public class InverTree {
	public TreeNode invertTree(TreeNode root) {
		InverTree.Revert(root);
        return root;
    }
    public static void Revert(TreeNode root){
        if(root==null)
            return;
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        if(root.left!=null)
        	InverTree.Revert(root.left);
        if(root.right!=null)
        	InverTree.Revert(root.right);
    }
}
