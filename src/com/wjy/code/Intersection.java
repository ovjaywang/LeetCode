package com.wjy.code;

import java.util.HashSet;
import java.util.Set;
/*
 * 求两个数组的交集 单个数组可能有重复数字 也可能为空-349
 */
public class Intersection {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> S1 = new HashSet<Integer>();
        Set<Integer> S2 = new HashSet<Integer>();
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> rs = new HashSet<Integer>();
        for (Integer i : nums1) {
				S1.add(i);
		}
        for (Integer i : nums2) {
				S2.add(i);
		}
        for (Integer i : S1) {
			if(!a.add(i)){
				rs.add(i);
			}
		}
        for (Integer i : S2) {
			if(!a.add(i)){
				rs.add(i);
			}
		}
        int[] aa =  new int[rs.size()];
        int j=0;
        for (int i : rs) {
			aa[j] = i;
			j++;
		}
        return aa;
    }
}
