package com.wjy.code;

import java.util.Stack;

public class QuickSort {
	public static void main(String[] args) {
		int[] fff = {3,5,0,-4,2,1,40,-5,9,-23,4,6};
//		QuickSort.Quick_Sort(fff, 0, fff.length-1);
//		for (int i : fff) {
//			System.out.println(i+" ");
//		}
		QuickSort.Quick_Sort_Stack(fff);
	}
	static int  partition(int[] a,int low,int high){
		int key =  a[low];
		while(low<high){
			while(a[high]>=key && low<high){
				high--;
			}
			a[low] = a[high];
			while((a[low]<=key) && low<high){
				low++;
			}
			a[high] = a[low];
		}
		a[low] = key;
		return low;
	}
	static void Quick_Sort(int[]a ,int low,int high){
		if(low < high){
			int mid =QuickSort.partition(a, low, high);
			QuickSort.Quick_Sort(a, low	, mid-1);
			QuickSort.Quick_Sort(a, mid+1, high);
		}
	}
	
	static void Quick_Sort_Stack(int[]a){
		Stack<Integer> st = new Stack<Integer>();
		int low =0,high = a.length-1;
		if(low<high){
	        int mid=partition(a,low,high);
	        if(low<mid-1){
	            st.push(low);
	            st.push(mid-1);
	        }
	        if(mid+1<high){
	            st.push(mid+1);
	            st.push(high);
	        }
	        int q,p;
	        //其实就是用栈保存每一个待排序子串的首尾元素下标，下一次while循环时取出这个范围，对这段子序列进行partition操作
	        while(!st.empty()){
	            q= st.pop();
	            p=st.pop();
	            mid=partition(a,p,q);
	            if(p<mid-1){
	                st.push(p);
	                st.push(mid-1);
	            }
	            if(mid+1<q){
	                st.push(mid+1);
	                st.push(q);
	            }      
	        }
		for (Integer iii : a) {
			System.out.println(iii+" ");
		}
	}
}}