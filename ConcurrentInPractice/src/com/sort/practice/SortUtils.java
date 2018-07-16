package com.sort.practice;

public class SortUtils {
	public static boolean less(Comparable V,Comparable W) {
		// V小于W返回true
		return V.compareTo(W) < 0;
	}
	
	/**
	 * 元素位置互换
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Comparable[] a,int i,int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
}
