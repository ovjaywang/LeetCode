package com.wjy.code;
/**
 * 求取两个数最大公约数
 * @author Jay Wang
 *
 */
public class ZuiDaGongYueShu {
		public static int getzdgys(int x,int y){
			if(y == 0)
				return x;
			if(y == 1)
				return y;
			return getzdgys(y,x%y);
		}
		public static void main(String[] args) {
			System.out.println(getzdgys(8,12));
			System.out.println(getzdgys(96,144));
			System.out.println(getzdgys(35,7));
			System.out.println(getzdgys(17,15));
			System.out.println(getzdgys(3,1));
		}
}
