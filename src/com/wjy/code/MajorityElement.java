package com.wjy.code;
/**
 * 找出数组中超过一半的数据
 * @author Administrator
 *
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
    	return selectNums(nums);
    }
    public int selectNums(int[] nums){
    	int index;
    	int i=0,j=nums.length-1;
    	while(i<j){
    		if(nums[i]!=nums[j]){
    			i++;
    			j--;
    		}else{//如果相等
    			index = i+1;
    			while(nums[i] == nums[index] && index<j){
    				index++;    						
    			}
    			if(index <j){
    				nums[index] ^= nums[i];
    				nums[i] ^= nums[index];
    				nums[index] ^= nums[i];
    				System.out.println("执行交换  "+i +"与"+index+"  "+nums[i]+"-"+nums[index]);
    			}else{
    				break;
    			}
    		}
    	}
    	return nums[i];
    	
    }
    public static void main(String[] args) {
		MajorityElement mje = new MajorityElement();
		int [] nums = {10,9,9,9,10};
		System.out.println(mje.majorityElement(nums));;
	}
}
