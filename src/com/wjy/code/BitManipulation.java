package com.wjy.code;

public class BitManipulation {
	void transValue(int a,int b){
		a ^= b;
		b ^= a;
		//a ^=b;
		System.out.println(a+" "+b);
		
	}
	void transValue2(char a,char b){
		a ^= b;
		b ^= a;
		a ^=b;
		System.out.println(a+" "+b);
		
	}
	private boolean is4Power(int a){
		String b=Integer.toBinaryString(a);
		if((b.length()-1)%2!=0) return false;
 		return a==0 ? false : ((a-1)&a)==0;
	}
	public static void main(String[] args) {
		BitManipulation bm = new BitManipulation();
		//bm.transValue(4,5);
		System.out.println(bm.is4Power(64));;
		//bm.transValue2("h".toCharArray()[0], "g".toCharArray()[0]);
	}
}
