package com.wjy.onlineCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 比较两个字符串的顺序
 * @author Administrator
 *
 */
public class CompareString {
	public static void main(String[] args) {
		System.out.println(CompareString.isStrOrder("caa", "cats"));;
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> strList = new ArrayList<String>();
        for(int i = 0; i < n; i++){
                strList.add(sc.next());
        }
        boolean isLength=true;
    	boolean isStrOrder = true;
        int j=1;
    	while(j<n){
            if(strList.get(j-1).length()>strList.get(j).length()){
            	isLength = false;
            	break;
            }
            j++;
        }
    	j=1;
    	while(j<n){
			isStrOrder = isStrOrder&&(isStrOrder(strList.get(j-1),strList.get(j)));
			j++;
    	}
    	if(isStrOrder && !isLength){
    		System.out.println("lexicographically");
    	}else if(!isStrOrder && isLength){
    		System.out.println("lengths");
    	}else if(isStrOrder && isLength){
    		System.out.println("both");
    	}else{
    		System.out.println("none");
    	}
    	
	}
	static boolean isStrOrder(String a,String b){
		char [] aa = a.toCharArray();
		char [] bb = b.toCharArray();
		int i=0;
		int len = (aa.length>bb.length)?bb.length:aa.length;
		while (i<len) {
			if(aa[i]<bb[i])
				return true;
			else if(aa[i]>bb[i])
				return false;
			i++;
		}
		return true;
	}
}
