package com.sort.practice;

import java.util.Random;

public class MergeSort {
	private static Comparable[] aux;
	public static void merge(Comparable[] a,int start,int mid,int end) {
		// 将a[start,mid] 和 a[mid + 1, end]归并
		int i = start;
		int j = mid + 1;
		// 将a[start,end] 复制到aux[start,end]
		for (int k = start; k <= end ;k ++) {
			aux[k] = a[k];
		} 
		
		// 归并到a[start,end]
		for (int k = start; k <= end ;k ++) {
			if (i > mid) {
				a[k] = aux[j ++];
			} else if (j > end) {
				a[k] = aux[i ++];
			} else if (SortUtils.less(aux[j], aux[i])) {
				a[k] = aux[j ++];
			} else {
				a[k] = aux[i ++];
			}
		} 
	}
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length]; 
		sort(a,0,a.length - 1);
	}

	private static void sort(Comparable[] a, int start, int end) {
		if (start >= end) {
			return;
		} 
		int mid = (start + end) / 2;
		sort(a,start,mid);
		sort(a,mid + 1,end);
		merge(a, start, mid, end);
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
