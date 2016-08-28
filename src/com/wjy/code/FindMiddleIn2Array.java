package com.wjy.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 在两个有序数组中找到中位数 限在O(lg(m+n)) n m 为二数长度 （时间复杂度O(n) 最好达到O(lng(n))）
 * @author Jay Wang
 *
 */
public class FindMiddleIn2Array {
	public static void main(String[] args) {
		int b[] = {-3,-1,1,2};
		int a[] = {3,5,6,7};
		System.out.println(FindMiddleIn2Array.findMedianSortedArrays(a,b));
		System.out.println(FindMiddleIn2Array.findMedianSortedArrays2(a,b));
	}
	//弱智拼接查找
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        List<Integer> list = new ArrayList<Integer>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length){
            list.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            list.add(nums2[j]);
            j++;
        }
        int l =nums1.length+nums2.length;
        if(l%2 == 0){
            return ((double)(list.get(l/2)+list.get(l/2-1)))/2;
        }else{
            return list.get((l-1)/2);
        }
    }
    
    public static double findMedianSortedArrays2(int [] nums1,int[] nums2){
    	int imin=0,imax=nums1.length-1;
    	return 0.0;
    }
}
