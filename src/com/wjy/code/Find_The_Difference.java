package com.wjy.code;
/**
 * �ַ���t��s�Ļ����������һ����Ļ-LeetCode-389
 * @author Administrator
 *
 */
public class Find_The_Difference {
	public static void main(String[] args) {
		String s = "abcde";
		String t = "abcdfe";
		Find_The_Difference.getDifference(s, t);
	}
	static char getDifference(String s,String t){
		char [] ss = s.toCharArray();
		char rs = 0;
		for (char c : ss) {
			rs ^= c;
		}
		char [] tt  = t.toCharArray();
		for (char c : tt) {
			rs ^= c;
		}
		System.out.println(rs);
		return rs;
	}
}
