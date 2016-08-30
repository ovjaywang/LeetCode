package com.wjy.code;

import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

public class BaiShuProblem {
	static int count=0;
	static Stack<String> s =  new Stack<String>();
	static StringBuffer sb = new StringBuffer();
	//static int[] a={1,2,3,4,5,6,7,8,9};
	static int[] a={1,2,3};
	static SortedMap<Integer, Boolean> hm = new TreeMap<Integer, Boolean>();
	static int size = a.length;
	static final int sum=0;
	public static void main(String[] args) {
		BaiShuProblem.Calculate(0,0,0);
	}
	static int isPlus(int c){
		if(hm.size()==0)
			return 0;
		int hightKey =hm.lastKey();
		if(hightKey>c)
			return 0;
		return (hm.get(hightKey))?1:2;
	}
	
	static void Calculate(int cur,int n,int last){
 		if(cur == size-1){//遍历到最后一个可插位置
			last = last*10+a[cur];
			int boo = isPlus(cur-1);
			if((boo==1 && (n+last)==sum)||(boo==2 && (n-last)==sum)){
				count++;
				for (int i = 0; i < size; i++) {
					System.out.print(a[i]);
					if(hm.get(i)!=null){
						System.out.print(hm.get(i)?"+":"-");
					}
				}
				System.out.println();
				System.out.println("n :"+n+"  last:"+last);
				System.out.println(count);
				return;
			}
			return;
		}
		Calculate( cur+1, n - last + 10*last+a[cur], 10*last+a[cur]);
		
		last = 10*last+a[cur];
		System.out.println("last:"+ last+" N ="+n);

		int isAdd = isPlus(cur);
		hm.put(cur, true);
		if(isAdd!=0){
			Calculate(cur+1, (isAdd==1)?n+last:n-last, 0);
		}else{
			Calculate(cur+1,  n, 0);
		}
		//hm.remove(hm.lastKey());
		hm.put(hm.lastKey(),false);
		if(isAdd!=0){
			Calculate(cur+1, (isAdd==2)?n-last:n+last, 0);
		}else{
			Calculate(cur+1, n, 0);
		}
		hm.remove(hm.lastKey());

		return;
	}
}
