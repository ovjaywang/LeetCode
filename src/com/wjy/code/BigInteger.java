package com.wjy.code;

public class BigInteger {
	public static void main(String[] args) {
		BigInteger bi = new BigInteger();
		System.out.println(bi.getBigIntegerMul("123456789", "987654321"));
		System.out.print(bi.getBigIntegerPlus("9", "9999"));
	}
	private String getBigIntegerMul(String a,String b){
		StringBuffer sb = new StringBuffer();
		int l = a.length() + b.length();
		int [] rss = new int[l];
		for (int i : rss) {
			rss[i] =0;
		}
		int carry = 0;
		//Integer.parseInt(String.valueOf(a.charAt(2)));
		for (int i= b.length()-1;i>=0;i--) {
			for (int j =a.length()-1;j>=0;j--) {
				int value = Integer.parseInt(String.valueOf(b.charAt(i))) *Integer.parseInt(String.valueOf(a.charAt(j))) + carry +rss[l-i-1-j-1];
				rss[l-i-1-j-1]  =  (value%10);
				carry = value/10;
			}
			if(carry !=0){
				int index =l-1-i;
				rss[index] = carry;
			}
			carry = 0;
		}
		if(rss[rss.length-1]!=0)	sb.append(rss[rss.length-1]);
		for (int i = 1; i < rss.length; i++) {
			sb.append(rss[rss.length-1-i]);
		}
		return sb.toString();
	}
	private String getBigIntegerPlus(String a,String b){
		StringBuffer sb = new StringBuffer();
		int i=0,carry=0,value=0;
		int l_a=a.length(),l_b=b.length();
		while(i<l_a&&i<l_b){
			value = Integer.parseInt(String.valueOf(a.charAt(l_a-1-i)))+Integer.parseInt(String.valueOf(b.charAt(l_b-1-i))) + carry;
			sb.append((value%10));
			carry = value/10;
			i++;
		}
		while (i<l_a || i<l_b) {
			if(i<l_a){
				value = Integer.parseInt(String.valueOf(a.charAt(l_a-1-i)))+carry;
				sb.append(value%10);
				carry= value/10;
				i++;
			}else {
				value = Integer.parseInt(String.valueOf(b.charAt(l_b-1-i)))+carry;
				sb.append(value%10);
				carry= value/10;
				i++;
			}
		}
		if(carry>0)	sb.append(carry);
		return sb.reverse().toString();
	}
}	
