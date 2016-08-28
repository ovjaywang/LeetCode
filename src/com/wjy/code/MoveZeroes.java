package com.wjy.code;
/**
 * 把0移到数组的末位-双下标法 
 * @author Administrator
 *
 */
public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
    	int j = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		continue;
        	}else{
        		nums[j]=nums[i];
        		j++;
        	}
        }
        if(j<nums.length){
        	for(;j<nums.length;j++){
        		nums[j]=0;
        	}
        }
        for (int i : nums) {
			System.out.print(i+" ");
		}
        return nums;
    }
    public static void main(String[] args) {
    	MoveZeroes mz = new MoveZeroes();
    	mz.moveZeroes(new int[]{1,0,3,0,4,0,5});;
	}
}
