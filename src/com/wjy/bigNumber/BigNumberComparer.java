package com.wjy.bigNumber;

import java.math.BigInteger;

public class BigNumberComparer {
	public static void isFirstOneBig(BigInteger a,BigInteger b) {       
	            int ans = a.compareTo(b);    
	            if(ans == 0){    
	                System.out.println("a==b");                 
	            }    
	            else if(ans < 0){    
	                System.out.println("a<b");    
	            }    
	            else{    
	                System.out.println("a>b");                   
	            }        
	}
	public static void main(String[] args) {
		BigNumberComparer.isFirstOneBig(new BigInteger("1234253657645235245345623426"), new BigInteger("98435032457239847562096226"));
	}
}
