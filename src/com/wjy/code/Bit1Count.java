package com.wjy.code;
/**
 *�����������1����ż��������������������������
 *@author Jay Wang 
 */

public class Bit1Count {
	public static int get11Count(int x){
		int i=0;
		for(int j =0 ;j<32;j++){
			if((x&1)==1)
				i ^= x&1;//����Ŀ��i++
			x >>= 1;
		}
		return i;
	}
	public static int get1Count(int x){//���ض���������ż������������1 ż������0 ��������1
	        x = x ^ (x >> 1);
	        x = x ^ (x >> 2);
	        x = x ^ (x >> 4);
	        x = x ^ (x >> 8);
	        x = x ^ (x >> 16);
	        //System.out.println(x&1);
	    return x&1;
	}
	public static int get1Count2(int x){//ɵ�Ϸ�ʽ
		int[] count = new int[2];
		String s = Integer.toBinaryString(x);
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i)==48)
				count[0] +=1;
			else
				count[1] +=1;
		}
		return count[1];
	}
	public static void main(String[] args) {
		int hhe = 5;
		System.out.println(Integer.toBinaryString(hhe));
		System.out.println(get11Count(hhe));
		System.out.println(get1Count(hhe));
		System.out.print(get1Count2(hhe));
	}
}
