package com.wjy.code;

public class RotationSubString {
	public static void main(String[] args) {
		int [] nn= {1,2,3,4,5,6,7,89,0,532};
		RotationSubString.rotate(nn, 5);
		for (int i : nn) {
			System.out.print(i+" ");
		}
	}
    public static void rotate(int[] nums, int k) {
        if((k%nums.length)==0)
            return;
        k = k%nums.length;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    public static void reverse(int[] nums,int low,int high){
        while(low<high){
            nums[low] ^= nums[high];
            nums[high] ^= nums[low];
            nums[low] ^= nums[high];
            high--;
            low++;
        }
    }
}
