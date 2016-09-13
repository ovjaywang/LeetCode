package com.wjy.code;

import java.util.ArrayList;
import java.util.List;
/**
 * 返回金字塔第k行是什么
 * @author Administrator
 *
 */
public class PascalKRow {
	public static void main(String[] args) {
		PascalKRow kRow = new PascalKRow();
		System.out.println(kRow.getRow(4));;
	}
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<Integer>();
        if(rowIndex<0)
            return l;
        l.add(1);
        if(rowIndex==0){
            return l;
        }
        l.add(1);
        if(rowIndex==1){
            return l;
        }
        while(rowIndex>1){
            l = getNextLine(l);
            rowIndex--;
        }
        return l;
    }
    List<Integer> getNextLine(List<Integer> ll){
    	char [][] a = {{'a','b'},{'c','d'}};
    	char [] aa = a[0];
        int i = ll.get(0), k = ll.get(1),j;
        int index = 1;
        while((index+1) < ll.size()){
            int p = i+k;
            i = ll.get(index);
            k = ll.get(index+1);
            
            ll.set(index, p);
            index++;
        }
        ll.set(index,i+k);
        ll.add(1);
        return ll;
    }
}
