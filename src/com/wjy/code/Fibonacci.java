package com.wjy.code;
/**
 * 迭代求取斐波那契数列
 * @author Administrator
 *
 */
public class Fibonacci {
	public static long fbnq(long n){
		return _fbnq(n);
	}
	private static long _fbnq(long n){
		if(n==1)
			return 1;
		if(n==0)
			return 1;
		else
			return _fbnq(n-1)+_fbnq(n-2);
	}
	public static void main(String[] args) {
		for (long i = 0; i < 15; i++) {
			System.out.println(fbnq(i));
		}
	}
}
