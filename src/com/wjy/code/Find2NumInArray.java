package com.wjy.code;
/**
 * ��һ�������в���Ψ����
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
			if(((num&(1<<index))^(1<<index))==0)//��ȡ��indexλ��100����0λ�Ƚ� �����ͬ ���ҵ���һ��1��λ��
				return index+1;
			else
				index++;
		}
		return -1;
	}
	public static boolean is1AtPos(int num,int pos){//�жϵ�posλ�Ƿ�Ϊ1
		return ((num>>(pos-1))&1)==1;
	}
	public static int[] get2Num(int[] a){
		int [] find2Num = new int[2];
		int rs = 0;
		for(int i=0;i<a.length;i++)
			rs ^= a[i];
		
		System.out.println(rs);
		
		int pos=getFirst1(rs);//�ҵ�Ψ���������Ķ�������ĩλ��һ��1���ֵ�λ�ã����������1������1��Ȼ��1��0�������ġ�
		for (int j : a) {
			if(is1AtPos(j,pos))
				find2Num[0] ^= j;//����һλ����1�����
			else
				find2Num[1] ^= j;//����һλ����0�����
		}
		System.out.println(find2Num[0]+" "+find2Num[1]);
		return find2Num;
	}
}
