package com.wjy.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 返回第一个不重复的字符
 * @author Jay Wang
 *
 */
public class FirstNoUniqChar {
	public static void main(String[] args) {
		FirstNoUniqChar firstNoUniqChar =new FirstNoUniqChar();
		System.out.println(firstNoUniqChar.firstUniqChar("loveleetcode"));;
	}
	public int firstUniqChar(String s) {
        char []c = s.toCharArray();
        List<Integer> vol = new ArrayList<Integer>();
        List<Integer> count = new ArrayList<Integer>();
        for (int i=0;i<c.length;i++) {
        	int v = c[i]-'a';
			if(vol.contains(v)){
				int ccc = count.get(vol.indexOf(v));
				count.set(vol.indexOf(v), ccc+1);
			}else{
				vol.add(v);
				count.add(1);
			}
		}
        int ans = 0;
        for(int i=0;i<count.size();i++){
        	if(count.get(i)==1){
        		return s.indexOf(vol.get(i)+'a');
        	}
        }
        return -1;
    }
}
