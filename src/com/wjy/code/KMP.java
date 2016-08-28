package com.wjy.code;
/**
 * 经典字符串匹配算法
 * @author Administrator
 *
 */
public class KMP {
	public static void main(String[] args) {
		String s="abcaabcd";
		char[] ss = s.toCharArray();
		int[] h = getNext(s);
		for (char i : ss) {
			System.out.print(String.valueOf(i).toString()+" ");
		}System.out.println();
		for (int j : h) {
			System.out.print(j+" ");
		}
		System.out.println();
		int[] hh= getNext2(s);
		for (int j : hh) {
			System.out.print(j+" ");
		}
	}
	private static int[] getNext(String pattern){
		char[] a = pattern.toCharArray();
		int[] rs = new int[pattern.length()];
		rs[0] = 0;
		for (int i = 1; i < pattern.length(); i++) {
			int j=0;
			int p = i;
			String aaa= String.valueOf(a[0]);
			String bbb = String.valueOf(a[i-1]);
			System.out.println("当前首末:"+aaa +" "+bbb + "  当前遍历Index : "+i);
			while((j<(i-2))){
				if(aaa.equals(bbb))
					rs[i] = j+1;
				j++;
				aaa= pattern.substring(0, j+1);
				bbb = pattern.substring(p-j-1,p);
				System.out.println("当前比较子串 ： "+aaa +" "+bbb+"\t当前ij  "+j+" "+i);
			}
			System.out.println("Next"+i+":"+rs[i]);
		}
		return rs;
	}
	private static int[] getNext2(String s){
		int[] rs = new int[s.length()];
		rs[0] = -1;
		int k=-1;
		int j=0;
		while(j<s.length()-1){
			if(k==-1 || (s.substring(j, j+1)).equals(s.substring(k,k+1))){
				++j;
				++k;
				rs[j] = k;
			}
			else {
				k = rs[k];
			}
		}
		return rs;
	}
}
