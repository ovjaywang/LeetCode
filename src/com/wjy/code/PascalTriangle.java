package com.wjy.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ½ð×ÖËþÊý
 * @author Jay Wang
 *
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> ls= new ArrayList<List<Integer>>();
    	List<Integer> tmp= new ArrayList<Integer>();
    	if(numRows<=0) {
    		return ls;
    		}
		tmp.add(1);
		ls.add(tmp);
    	int i = 1 ;
    	while(i < numRows){
    		 tmp = insertArray(tmp,ls);
    		 i++;
        }
    	System.out.println(ls);
    	return ls;
    }
    private List<Integer> insertArray(List<Integer> l,List<List<Integer>> llll){
    	List<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(1);
    	for(int i=0;i<l.size()-1;i++){
    		tmp.add(l.get(i)+l.get(i+1));
    	}
    	tmp.add(1);
    	llll.add(tmp);
    	return tmp;
    }
    public static void main(String[] args) {
    	PascalTriangle pt= new PascalTriangle();
    	pt.generate(9);
	}
}
