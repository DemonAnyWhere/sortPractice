package com.sort.practice;

import java.util.Random;

public class ShellSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			for(int i = h; i < N; i ++) {
				for (int j = i; j >= h && SortUtils.less(a[j], a[j - h]); j -= h) {
					SortUtils.exch(a, j, j - h);
				}
			}
			h = h / 3 ;
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
