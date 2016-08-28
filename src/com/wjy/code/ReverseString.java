package com.wjy.code;
/**
 * ·´×ª×Ö·û´®
 * @author Administrator
 *
 */
public class ReverseString {
	public String reverseString(String s) {
        int l = s.length();
        char[] sss = s.toCharArray();
        for(int i=0;i<l/2;i++){
        	System.out.println(sss[i]);
            sss[i] ^=sss[l-1-i];
            sss[l-1-i] ^=sss[i];
            sss[i] ^=sss[l-1-i];
        }
        return String.valueOf(sss);
    }
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseString("asdfastjooin"));;
	}
}
