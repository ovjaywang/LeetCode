package com.wjy.code;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {
	public String reverseVowels(String s) {
		char[] sss = s.toCharArray();
        int j=0,i=sss.length-1;
        char[] c = "aeiou".toCharArray();
        List<Object> al = new ArrayList<Object>();
        for (char c2 : c) {
			al.add(c2);
		}
        for(;j<i;){
        	if(!al.contains(sss[j]))	
        		{j++;
        		continue;
        		}
        	if(!al.contains(sss[i])){
        		i--;
        		continue;
        	}
        	sss[j] ^= sss[i];
        	sss[i] ^= sss[j];
        	sss[j] ^= sss[i];
        	j++;
        	i--;
        }
        return String.valueOf(sss);
    }
	public static void main(String[] args) {
		ReverseVowels rv =   new ReverseVowels();
		System.out.println(rv.reverseVowels("leetcode"));
	}
}
