package com.wjy.code;

import java.util.ArrayList;
import java.util.List;

//���Ƕ��������߼� �����ʵ��
public class Heap {
	static List<Integer> heap = new ArrayList<Integer>(); //���ﹹ��󶥶�
	public static void insert(int v){
		if(heap.size()==0){//�±�Ϊ0��λ�ò���Ԫ��
			heap.add(0);
		}
		heap.add(v);
		Heap.heapUp(heap,heap.size()-1);//���Ԫ���������ĩλ Ȼ���������
	}
	public static void heapUp(List<Integer> h,int index){
		if(h.get(index)>h.get(index/2) && index>1){
			int v = h.get(index);
			int r = h.get(index/2);
			h.set(index/2, v);
			h.set(index,r);
			Heap.heapUp(h,index/2);
		}
	}
	public static void delete(List<Integer> h,int index){
		if(index == h.size()-1){
			h.remove(index);
			return;
		}
		h.set(index, h.get(h.size()-1));
		h.remove(h.size()-1);
		Heap.heapDown(h,index);
	}
	public static void heapDown(List<Integer> h,int index){
		if(h.size()>(index *2)){
			int v = h.get(index);
			int left = h.get(index *2);
			if(h.size()==(index*2+1) ){
				if( h.get(index)<h.get(index*2)){
					h.set(index, left);
					h.set(index *2, v);
					Heap.heapDown(h,index*2);
				}
			}else {
				int right = h.get(index*2+1);
				if(left > v || right >v){
					boolean isLeft = (left>right);
					if(isLeft){
						h.set(index, left);
						h.set(index*2, v);
						Heap.heapDown(h,index*2);
					}else{
						h.set(index, right);
						h.set(index*2+1, v);
						Heap.heapDown(h,index*2+1);
					}
				}
			}
		}
	}
	public static void modify(List<Integer> h){
		for (int i = (h.size()-1)/2; i >0; i--) {
			Heap.heapDown(h, i);
		}
	}
	public static void heapSort(List<Integer> h){//�������Ҫ�������
		int size = h.size();
		for (int i = 1; i < size; i++) {//����ʱ�临�Ӷ� nlgn �������ȶ���
			System.out.print(h.get(1)+" ");
			h.set(1,h.get( h.size()-1));
			h.remove(h.size()-1);
			Heap.heapDown(h, 1);//ʱ�临�Ӷ�O(lg(N))
		}
	}
	public static void main(String[] args) {
		int[] nums={3,5,9,10,2,-1,4,6,1,11,7,8,-3};
		for (int i : nums) {
			Heap.insert(i);
		}
		System.out.println("�����󶥶ѣ��նѲ��뷨 ÿ�β�������ѽṹ��");
		System.out.println(Heap.heap);
		int index = 3;
		Heap.delete(Heap.heap, index);
		System.out.print("ɾ��Index Ϊ"+index+" ");
		System.out.println(Heap.heap);
		
		System.out.println("������������������������������������������������");
		System.out.println("�����󶥶ѣ��ɶѵ����� ����ȫ���������� Ȼ������һ����֧�ڵ����������");
		List<Integer> h2 = new ArrayList<Integer>();
		h2.add(0);
		for (int i : nums) {
			h2.add(i);
		}
		Heap.modify(h2);
		System.out.println(h2);
		Heap.heapSort(h2);
	}
}
