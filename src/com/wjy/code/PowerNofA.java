package com.wjy.code;

public class PowerNofA {
	public static void main(String[] args) {
		Power(2,8);;
	}
	public static long Power(int a, int n){
		long ans = 1;
		//System.out.println(Integer.SIZE);
		System.out.println("��ָ�������ƣ�"+Integer.toBinaryString(n));
		while (n > 0) {
			if ((n & 1)!=0) {//ĩλ��Ϊ��
				ans *= a;
			} 
			a *= a;//���㵱ǰ�ݴ�
			n >>= 1;//����ÿ����һλ
			System.out.println(ans);
		}
		return ans;
	}
}
