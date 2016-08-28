package com.wjy.code;
/**
 * 获取给定数组中最小子数组（连续）
 * @author Jay Wang
 *
 */
public class MaxSubArray {
	public static int getMaxSubArray(int[] nums){
        int sum=0,ans=Integer.MIN_VALUE;
        int maxI=0,maxJ=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
	        if(sum<0){
	            sum=0;
	        }
	        if(sum>ans){
	           	ans = sum;
	           	maxJ = i;
	           }
        }
        return ans;
	}
	
	public static void main(String[] args) {
		int[] ns = {-2,1,3,-4,5,-3,0,2,7,-6};
		System.out.println(MaxSubArray.getMaxSubArray(ns));
	}
}
