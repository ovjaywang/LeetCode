package com.wjy.code;
/**
 * 
 * ɾ������õ�������ظ����� �ռ临�Ӷ�ΪO(1).
 * @author Jay Wang
 *
 */
public class RemoveDuplicationFromSortArray {
	    public int removeDuplicates(int[] nums) {
	        if(nums==null)
	            return 0;
	        if(nums.length<=1)
	            return nums.length;
	        int pre = nums[0];
	        int j=0;
	        for(int i=1;i<nums.length;i++){
	            if(nums[i]== pre){
	                continue;
	            }else{
	                nums[j+1] = nums[i];
	                pre = nums[i];
	                j++;
	            }
	        }
	        return j+1;
	    }
}
