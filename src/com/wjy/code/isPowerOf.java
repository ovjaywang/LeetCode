package com.wjy.code;

public class isPowerOf {
	public static void main(String[] args) {
		System.out.println("INT×î´óÖµ"+Integer.MAX_VALUE);
		System.out.println(isPowerOf2(2048));
		System.out.println(isPowerOf3(243));
		System.out.println(isPowerOf4(4096));
	}
	static boolean isPowerOf2(int a){
		return (a&(a-1))==0;
	}
	static boolean  isPowerOf3(int a){
		return a>0 && 1162261467%a==0;
	}
	static boolean isPowerOf4(int a){
		return a>0 && 1073741824%a==0;
	}
}
