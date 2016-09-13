package com.wjy.onlineCode;

import java.util.Scanner;
/**
 * 把奇数移到左边 偶数移到右边
 * @author Administrator
 *
 */
public class Move {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =sc.nextLine();
		String [] a=  str.split(",");
		int[] nums  =new int[a.length];
		for (int i=0;i<a.length;i++) {
			nums[i]  =Integer.valueOf(a[i]);
		}
		int p=0,q=nums.length-1,tmp=nums.length-1,l=0;
		while((nums[l]%2==0) && (tmp<nums.length)){
			l++;
		}
		while((nums[q]%2==1) && (tmp>=0)){
			tmp--;
		}
		StringBuilder sb = new StringBuilder();
		if(tmp<0 || l==nums.length){
			for (int i : nums) {
				sb.append(i+",");
			}
		}
		else{
			nums[q] ^=nums[tmp];
			nums[tmp]^=nums[q];
			nums[q]^=nums[tmp];
			
			nums[l] ^=nums[p];
			nums[p]^=nums[l];
			nums[p]^=nums[p];
		}
		while(p<q){
			while(p<q &&(nums[p]%2==1)){
				p++;
			}
			while(p<q && (nums[q]%2)==0){
				q--;
			}
			nums[q] ^=nums[p];
			nums[p]^=nums[q];
			nums[q]^=nums[p];
		}
		for (int i : nums) {
			sb.append(i+",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
