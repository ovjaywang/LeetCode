package com.wjy.code;
/**
 * �ҳ������г���һ�������
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
    		}else{//������
    			index = i+1;
    			while(nums[i] == nums[index] && index<j){
    				index++;    						
    			}
    			if(index <j){
    				nums[index] ^= nums[i];
    				nums[i] ^= nums[index];
    				nums[index] ^= nums[i];
    				System.out.println("ִ�н���  "+i +"��"+index+"  "+nums[i]+"-"+nums[index]);
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
