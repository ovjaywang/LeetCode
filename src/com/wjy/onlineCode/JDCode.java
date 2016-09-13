package com.wjy.onlineCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 找出记录过程中的最大值
 * @author 
 *
 */
public class JDCode {
	public static void main(String[] args) {
		//getGenFangHe();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		List<Integer> dayss= new ArrayList<Integer>();
		List<Integer> remainss= new ArrayList<Integer>();
		List<List<Integer>> datess = new ArrayList<List<Integer>>();
		List<List<Integer>> heighss = new ArrayList<List<Integer>>();
		List<Integer> dates =null;
		List<Integer> heighs =null;
		while(!str.isEmpty()){
			System.out.println("请输入记录：");
			int days = Integer.valueOf(str.split(" ")[0]);
			dayss.add(days);
			int remains = Integer.valueOf(str.split(" ")[1]);
			remainss.add(remains);
			System.out.println("天数和记录数为："+days+" "+remains);
			dates = new ArrayList<Integer>();
			heighs= new ArrayList<Integer>();
			for (int i = 0; i < remains; i++) {
				str = sc.nextLine();
				int d = Integer.valueOf(str.split(" ")[0]);
				int h = Integer.valueOf(str.split(" ")[1]);
				dates.add(d);
				heighs.add(h);
			}
			for (int  l=0;l<remains;l++) {
				System.out.print(dates.get(l)+"  "+heighs.get(l)+"\n");
			}
			//JDCode.getMaxHeight(days,remains,dates,heighs);
			datess.add(dates);
			heighss.add(heighs);
			str = sc.nextLine();
		}
		for (int k=0;k<dayss.size();k++) {
			getMaxHeight(dayss.get(k),remainss.get(k),datess.get(k),heighss.get(k));
		}
		sc.close();
	}

	
	 static void getMaxHeight(int days,int remains,List<Integer> dates,List<Integer> heighs){
		if(remains>=1){
			for (int i=1;i<remains;i++){
				if(Math.abs((heighs.get(i)-heighs.get(i-1))/(dates.get(i)-dates.get(i-1)))>1){
					System.out.println("IMPOSSIBLE");
					return;
				}
			}
		}
		int max ;
		max = heighs.get(0)+(dates.get(0)-1);
		int max2 = heighs.get(remains-1)+(days-dates.get(remains-1));
		max = (max2>max)?max2:max;
		for (int j=1;j<remains;j++) {
			if(heighs.get(j)>=heighs.get(j-1)){
				max2 = heighs.get(j)+  ((dates.get(j)-dates.get(j-1))-(heighs.get(j)-heighs.get(j-1)))/2;
			}else{
				max2 = heighs.get(j-1)+ ((dates.get(j)-dates.get(j-1))-(heighs.get(j-1)-heighs.get(j)))/2;
			}
			max = (max2>max)?max2:max;
		}
		System.out.println(max);
	}
	
	
	static void getGenFangHe(){
		Scanner sc = new Scanner(System.in);
		List<Integer> JS = new ArrayList<Integer>();
		List<Integer> num =  new ArrayList<Integer>();
		String str=sc.nextLine();
		while(!str.isEmpty()){
			JS.add(Integer.valueOf(str.split(" ")[0]));
			num.add(Integer.valueOf(str.split(" ")[1]));
			str = sc.nextLine();
		}
		for (Integer i : JS) {
			System.out.print(i+" ");
		}
		for (Integer integer : num) {
			System.out.print(integer+" ");
		}
	}
}
