package com.wjy.code;
/**
 * ���鼯-�������Ͳ麯��
 * @author Administrator
 *
 */
public class UnionFindSet {
	private static int[] ufSet;
	private static int setN;
	private static int[] components;
	public UnionFindSet(int n){
		ufSet = new int[n];
		components = new int[n];
		this.setN =n;
		for (int i=1;i<n;i++) {
			ufSet[i] = i; 
			components[i] = 0;
		}
	}
	//����ֵΪj�ĸ��ڵ� ������ڵ�Ϊ�Լ� ����ʱû�в����������ϡ�
	public int  find(int j){
		if(j<0 || j>setN)
			return -1;
		int root,now=j;
		while(now!=ufSet[now]){
			now = ufSet[now];
		}
		root = now;
		now = j;
		int p;
		while(ufSet[now]!=root){
			p = ufSet[now];
			ufSet[now] = root;
			now = p;
		}
		return root;
	}
	//���� �Ѹ���������ͬ�Ľڵ�鲢��һ��
	public void union(int i,int j){
		int r1 = find(i);
		int r2 = find(j);
		if(r1!=r2){
			if(r1<r2){
				ufSet[r2] = r1;
			}else{
				ufSet[r1] = r2;
			}
		}
	}
	public int CalculateComponent(){
		for (int i=0;i<setN;i++) {
			find(i);
		}
		for (int j=0;j<setN;j++) {
			components[ufSet[j]]++;
		}
		int cps =0;
		for(int p=0;p<setN;p++){
			if(components[p]!=0){
				cps++;
			}
		}
		return cps;
	}
	public static void main(String[] args) {
		int  N =10;
		UnionFindSet ufs = new UnionFindSet(N);
//		ufs.union(2, 6);//���������Ԫ��
//		ufs.union(5, 6);
//		ufs.union(1, 8);
//		ufs.union(2, 9);
//		ufs.union(5, 3);
//		ufs.union(4, 8);
//		ufs.union(4, 0);
		
		ufs.union(1, 2);
		ufs.union(3, 6);
		ufs.union(4, 0);
		ufs.union(6, 7);
		ufs.union(9, 8);	
		ufs.union(8, 3);
		ufs.union(8, 2);
		ufs.union(5, 4);


		System.out.println("\n"+ufs.CalculateComponent());
		for (int i : ufSet) {
			System.out.print(i+" ");
		}
	}
}
