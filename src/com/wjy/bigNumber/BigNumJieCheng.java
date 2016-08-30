package com.wjy.bigNumber;

import java.math.BigInteger;

public class BigNumJieCheng {
	//StringBuffer sb = new StringBuffer();
	static void getBigNumJieCheng(long num){
		BigInteger ans = new BigInteger("1");    
        while(num > 0){    
            ans = ans.multiply(BigInteger.valueOf(num));    
            num -= 1;       
        }    
        System.out.println(ans);     
	}
	
	public static void main(String[] args) {
		BigNumJieCheng.getBigNumJieCheng(50);
	}
}
