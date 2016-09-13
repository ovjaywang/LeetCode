package com.wjy.onlineCode;

public class NeareastFebonaci {
	public static void main(String[] args) {
		System.out.println(_fbnq(new Long(15)));
	}
	private static long _fbnq(long num){
		long now=1,pre=1,prepre=0;
		while(pre+prepre<num){
			now = prepre+pre;
			prepre = pre;
			pre = now;
			System.out.println(now+" ");
		}
		long next = pre+prepre;
		long minus1 = num-now;
		long minus2 = next-num;
		return (minus1>minus2)?minus2:minus1;
	}
}
