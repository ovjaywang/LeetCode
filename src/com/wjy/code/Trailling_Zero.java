package com.wjy.code;
/**
 * ����n!��β����0����ľ
 * @author Jay Wang
 *
 */
public class Trailling_Zero {
	public static void main(String[] args) {
		int nn= 12;
		System.out.println(Trailling_Zero.getZero(nn));
	}
	public static int getZero(int n){
		int ans = 0;
		while(n>0){
			ans += n/5;
			n /=5;
		}
		
		return ans;
	}
}
