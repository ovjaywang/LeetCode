package com.wjy.onlineCode;

import java.util.Scanner;

public class PrintReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
       x =reverse(x);
       y= reverse(y);
       System.out.println(x);
       System.out.println(y);
       System.out.println(x+y);
        
	}
	static int reverse(int num){
		int ans=0;
		char[] s = String.valueOf(num).toCharArray();
		int len = s.length-1;
		StringBuilder sb = new StringBuilder();
		boolean skipZero = false;
		while(len>=0){
			if(s[len]=='0' && !skipZero){
				len--;
				continue;
			}
				sb.append(s[len]);
				skipZero = true;
			len--;
		}
		String ssss = sb.toString();
		return Integer.valueOf(ssss);
	}
}
