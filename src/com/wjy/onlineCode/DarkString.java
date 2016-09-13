package com.wjy.onlineCode;

import java.util.Scanner;

public class DarkString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>=1){}
	}
	static long getMi(int a, int k){
		long ans=1;
		while(k!=0){
			if(k%2==1)
				ans *= (long)a;
			k >>=1;
			a*=a;
		}
		return ans;
	}
	
	
}
