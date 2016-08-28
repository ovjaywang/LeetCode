package com.wjy.code;
/**
 * 在一个数列中查找唯二数
 * @author Administrator
 *
 */
public class Find2NumInArray {
	public static void main(String[] args) {
		int[] aa={1,2,3,2,5,6,4,5,6,1,3,8};
		get2Num(aa);
	}  
	public static int getFirst1(int num){
		int index = 0;
		while(index<32){
			if(((num&(1<<index))^(1<<index))==0)
				return index+1;
			else
				index++;
		}
		return -1;
	}
	public static boolean is1AtPos(int num,int pos){  	
		return ((num>>(pos-1))&1)==1;
	}
	public static int[] get2Num(int[] a){
		int [] find2Num = new int[2];
		int rs = 0;
		for(int i=0;i<a.length;i++)
			rs ^= a[i];
		int pos=getFirst1(rs);
		for (int j : a) {
			if(is1AtPos(j,pos))
				find2Num[0] ^= j;
			else
				find2Num[1] ^= j;			
		}
		System.out.println(find2Num[0]+" "+find2Num[1]);
		return find2Num;
	}
}
