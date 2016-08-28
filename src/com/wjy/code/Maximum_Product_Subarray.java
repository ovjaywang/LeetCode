package com.wjy.code;
/**
 * ��������ĳ������ĳ˻����ֵ �޶�Onʱ�临�Ӷ�
 * @author Jay Wang
 *
 */
public class Maximum_Product_Subarray {
	public static void main(String[] args) {
		int[] nums = {3,5,7,-2,4};
		System.out.println(Maximum_Product_Subarray.maxProduct(nums));
		System.out.println(Maximum_Product_Subarray.maxProduct2(nums));
		System.out.println(Maximum_Product_Subarray.maxProduct3(nums));
	}
	
    public static int maxProduct(int[] nums) {//��ʱ
        int product,ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            product = 1;
            for(int k=i;k<nums.length;k++){
                product *= nums[k];
                if(product > ans){
                    ans = product;
                }
            }
        }
        return ans;
    }
    //ͷ��β β��ͷ ��Ϊ���������������ȷ����һ��������
    public static int maxProduct3(int[] nums){
    	int max = nums[0],product=1;
    	for (int i : nums) {
			product *= i;
			if(product > max)
				max = product;
			if(i==0)
				product =1 ;
		}
    	product =1;
    	for (int i = nums.length-1; i>=0 ; i--) {
    		product *= i;
			if(product > max)
				max = product;
			if(i==0)
				product =1 ;
		}
    	return max;
    }
    
    //���α��� ÿһ�αȽ�������
    public static int maxProduct2(int[] A) {
    	if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    	}
    
    
    	public static int maxProduct33(int[] nums) {
            int max=nums[0],product=1;
            for(int i:nums){
                product *= i;
                if(max<product)
                    max = product;
                if(product==0)
                    product=1;
            }
            product = 1;
            for(int i=nums.length-1;i>=0;i--){
                product *= nums[i];
                if(max<product)
                    max = product;
                if(product ==0)
                    product =1;
            }
            return max;
        }
    }




