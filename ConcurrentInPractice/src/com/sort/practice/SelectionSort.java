package com.sort.practice;

import java.util.Random;

/**
 * @author lr
 */
public class SelectionSort {
	public static void sort(Comparable[] a) {
		// 将a按照升序排列
		int N = a.length;
		for (int i = 0; i < N; i ++) {
			// 找到最小元素索引并与第一位元素交换
			int min = i;
			for (int j = i + 1; j < N; j ++) {
				if (SortUtils.less(a[j], a[min])) {
					min = j;
				}
			}
			// 交换位置
			SortUtils.exch(a,i,min);
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
