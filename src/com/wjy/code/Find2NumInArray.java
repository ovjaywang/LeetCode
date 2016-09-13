package com.wjy.code;
/**
 * 在一个数列中查找唯二数
 * @author Administrator
 *
 */
public class Find2NumInArray {
	public static void main(String[] args) {
		System.out.println((2^2));
		System.out.println(2^0);
		int[] aa={1,2,3,4,6,4,6,8,1,3,8,5};
		get2Num(aa);
	}  
	public static int getFirst1(int num){
		int index = 0;
		while(index<32){
			if(((num&(1<<index))^(1<<index))==0)//截取后index位与100……0位比较 如果相同 则找到第一个1的位置
				return index+1;
			else
				index++;
		}
		return -1;
	}
	public static boolean is1AtPos(int num,int pos){//判断第pos位是否为1
		return ((num>>(pos-1))&1)==1;
	}
	public static int[] get2Num(int[] a){
		int [] find2Num = new int[2];
		int rs = 0;
		for(int i=0;i<a.length;i++)
			rs ^= a[i];
		
		System.out.println(rs);
		
		int pos=getFirst1(rs);//找到唯二数相亦或的二进制数末位第一个1出现的位置（不是零必有1）。而1必然是1与0亦或出来的。
		for (int j : a) {
			if(is1AtPos(j,pos))
				find2Num[0] ^= j;//将这一位贡献1的亦或
			else
				find2Num[1] ^= j;//将这一位贡献0的亦或
		}
		System.out.println(find2Num[0]+" "+find2Num[1]);
		return find2Num;
	}
}
