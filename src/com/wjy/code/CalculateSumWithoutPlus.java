package com.wjy.code;
/**
 * 不使用加号计算加法（可能有负数运算数字）
 * @author Jay Wang
 *
 */
public class CalculateSumWithoutPlus {
	public static void main(String[] args) {
		System.out.println(CalculateSumWithoutPlus.getSum(333, 777));
	}
	public static long getSum(long a, long b) {
        String aa=Long.toBinaryString(a);
		String bb=Long.toBinaryString(b);
		int i=aa.length()-1,j=bb.length()-1;
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		long s,t;
		while(i>=0 && j>=0){
			s = Long.valueOf(aa.charAt(i));
			t = Long.valueOf(bb.charAt(j));
			if(s==48 && t==48){
				sb.append(carry);
				carry = 0;
			}else if(s==49 && t==49){
				sb.append(carry);
				carry = 1;
			}else{
				if(carry ==1){
					sb.append(0);
					carry = 1;
				}else{
					sb.append(1);
					carry = 0;
				}
			}
			i--;
			j--;
		}
		while(i>=0){
			s = Long.valueOf(aa.charAt(i));
			if(carry + s<=49){
				sb.append(carry + s-48);
			}else{
				sb.append(0);
				carry = 1;
			}
			i--;
		}
		while(j>=0){
			t = Long.valueOf(bb.charAt(j));
			if(carry + t<=49){
				sb.append((carry + t-48));
			}else{
				sb.append(0);
				carry = 1;
			}
			j--;
		}
		if(carry ==1){
			sb.append(1);
		}
		return (int)Long.parseLong(sb.reverse().toString(), 2); // 2进制;
    }
}
