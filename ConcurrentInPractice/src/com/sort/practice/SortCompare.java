package com.sort.practice;

import java.util.Random;

/**
 * 排序比较
 * @author lr
 */
public class SortCompare {
	public static long time(String alg, Comparable[] a) {
		long start = System.currentTimeMillis();
		if (alg.equals("Insertion")) {
			InsertionSort.sort(a);
			long end = System.currentTimeMillis();
			return end - start;
		} else if (alg.equals("Selection")) {
			SelectionSort.sort(a);
			long end = System.currentTimeMillis();
			return end - start;
		}
		return 0;
	}
	
	public static long timeRandomInput(String alg,int N,int T) {
		long total = 0;
		Integer[] a = new Integer[N];
		for (int t = 0; t < T; t ++) {
			for (int i = 0; i < N; i ++) {
				a[i] = new Random().nextInt(10000);
			}
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		long selectionSortTime = timeRandomInput("Selection", 10000, 1000);
		long insertionSortTime = timeRandomInput("Insertion", 10000, 1000);
		System.out.println("选择排序用时:" + selectionSortTime);
		System.out.println("插入排序用时:" + insertionSortTime);
		System.out.println("插入排序比选择排序快" + (selectionSortTime / insertionSortTime) + "倍");
	}
	
}
