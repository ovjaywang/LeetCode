package com.wjy.code;
/**
 * 求取数字根
 * e.g. 128=1+2+8=11 1+1=2
 * e.g. 356=3+5+6=14 1+4=5
 * @author Jay Wang
 */
public class AddDigits {
	public static void main(String[] args) {
		AddDigits ad = new AddDigits();
		System.out.println(ad.addDigits(128));
	}
	private int addDigits(int num){
		int l=String.valueOf(num).length();
		return (num-1)%9+1;
	}
}
