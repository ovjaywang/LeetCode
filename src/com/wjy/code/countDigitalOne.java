package com.wjy.code;
/**
 * ���� 0-n�����ֵ�1���ܸ���
 * @author Administrator
 *
 */
public class countDigitalOne {
	public static void main(String[] args) {
		System.out.println(countDigitalOne.getOne(123));
	}
	public static int getOne(int n){
		int ones = 0;
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
	    return ones;
	}
}
