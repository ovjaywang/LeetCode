package com.wjy.code;
/**
 * 计算Excell表格的字符代表的行数
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcellNumber {

	public static void main(String[] args) {
		System.out.println(getNum("ABC"));
	}
	
	public static int getNum(String s){
		int num =0;
		int tmp;
		int len = s.toCharArray().length;
		for (int i=0;i<len;i++) {
			tmp = s.charAt(i)-'A'+1;
			num += tmp* Math.pow(26, (len-i-1));
		}
		return num;
	}
}
