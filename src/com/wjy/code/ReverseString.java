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
	
	public String reverseString2(String s){
		String[] ss = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = ss.length-1; i >-1; i--) {
			sb.append(ss[i]);
			if(i!=0){
				sb.append(" ");
			}
		}
		
		return sb.toString();
				
	}
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		System.out.println(rs.reverseString("asdfastjooin"));;
		System.out.println(rs.reverseString2("I am a student haha."));;
	}
}
