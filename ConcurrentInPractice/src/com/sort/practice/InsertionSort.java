package com.sort.practice;

import java.util.Random;

public class InsertionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i ++) {
			for (int j = i; j > 0 && SortUtils.less(a[j], a[j-1]); j --) {
				SortUtils.exch(a, j, j - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] a = new Integer[100];
		for (int i = 0; i < 100; i ++) {
			a[i] = random.nextInt(100);
		}
		sort(a);
		for (Integer integer : a) {
			System.out.print(integer + ",");
		}
	}
	
}
