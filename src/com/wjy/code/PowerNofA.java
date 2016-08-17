package com.wjy.code;

public class PowerNofA {
	public static void main(String[] args) {
		Power(2,8);;
	}
	public static long Power(int a, int n){
		long ans = 1;
		//System.out.println(Integer.SIZE);
		System.out.println("幂指数二进制："+Integer.toBinaryString(n));
		while (n > 0) {
			if ((n & 1)!=0) {//末位不为零
				ans *= a;
			} 
			a *= a;//计算当前幂次
			n >>= 1;//迭代每次推一位
			System.out.println(ans);
		}
		return ans;
	}
}
