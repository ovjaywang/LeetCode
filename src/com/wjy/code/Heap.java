package com.wjy.code;

import java.util.ArrayList;
import java.util.List;

//堆是二叉树的逻辑 数组的实现
public class Heap {
	static List<Integer> heap = new ArrayList<Integer>(); //这里构造大顶堆
	public static void insert(int v){
		if(heap.size()==0){//下表为0的位置不妨元素
			heap.add(0);
		}
		heap.add(v);
		Heap.heapUp(heap,heap.size()-1);//添加元素先添加在末位 然后随根上升
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
	public static void heapSort(List<Integer> h){//这里可能要把树清空
		int size = h.size();
		for (int i = 1; i < size; i++) {//总体时间复杂度 nlgn 不保持稳定性
			System.out.print(h.get(1)+" ");
			h.set(1,h.get( h.size()-1));
			h.remove(h.size()-1);
			Heap.heapDown(h, 1);//时间复杂度O(lg(N))
		}
	}
	 
	
	public static void main(String[] args) {
		int[] nums={3,5,9,10,2,-1,4,6,1,11,7,8,-3};
		for (int i : nums) {
			Heap.insert(i);
		}
		System.out.println("构建大顶堆（空堆插入法 每次插入调整堆结构）");
		System.out.println(Heap.heap);
		int index = 3;
		Heap.delete(Heap.heap, index);
		System.out.print("删除Index 为"+index+" ");
		System.out.println(Heap.heap);
		
		System.out.println("————————————————————————");
		System.out.println("构建大顶堆（成堆调整法 按完全二叉树排列 然后从最后一个分支节点逆序调整）");
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
