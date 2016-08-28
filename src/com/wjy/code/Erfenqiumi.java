package com.wjy.code;
/**
 * ¶ş·ÖÇóÃİ
 * @author Jay Wang
 *
 */
public class Erfenqiumi {
	public static void main(String[] args) {
		Erfenqiumi er = new Erfenqiumi();
		int a=5;
		int b=5;
		System.out.println(er.getMi(a,b));
		System.out.println(er.getMi_Feidigui(a, b));
	}
	private Long getMi(int a,int k){
		if(k==0) return 1L;
		if(k==1) return (long)a;
		else{
			if(k%2==0){
				Long tmp = getMi(a,k>>1);
				return tmp*tmp;
			}else{
				Long tmp = getMi(a,(k-1)>>1);
				return tmp*tmp*a;
			}
		}
	}
	private long getMi_Feidigui(int a, int k){
		long ans=1;
		System.out.println();
		while(k!=0){
			System.out.print(ans+" ");
			if(k%2==1)
				ans *= (long)a;
			k >>=1;
			a*=a;
		}
		return ans;
	}
}
