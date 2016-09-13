package com.wjy.code;
/**
 * 判断一个数字各数字平方和是不是1
 * @author Administrator
 *
 */
public class IsHappyNum {
	private static int tmp;
	public static void main(String[] args) {
		int n =19;
		System.out.println(isHappy(n));;
	}
	static boolean isHappy(int a){
		System.out.println(a);
		if(a<10 && a>tmp)
			return false;
		if(a==1)
			return true;
		tmp = a;
		int fuck = tmp,ans=0;
		int len = String.valueOf(a).length();
		while(fuck>0){
			ans += (fuck%10)*(fuck%10);		
			fuck /=10;
		}
		return isHappy(ans);
	}
}
