package com.wjy.onlineCode;

import java.util.Scanner;

public class Scan {
	 public static void main(String[] args) {
		         Scanner in =  new Scanner(System.in);
		         String s = in.nextLine();
		         String[] ss;
		         while(!s.isEmpty()){
		        	 ss = s.split(" ");
		        	 add(Integer.valueOf(ss[0]),Integer.valueOf(ss[1]));
		        	 s = in.nextLine();
		         }
		    }
	 
	 static void add(int a,int b){
		 System.out.println(a+"+"+b+" is "+(a+b));
	 }
}
