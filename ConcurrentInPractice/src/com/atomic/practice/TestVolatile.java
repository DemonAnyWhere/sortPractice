package com.atomic.practice;

public class TestVolatile {
	private static boolean flag;
	private static int num;
	
	private static class ReadThread extends Thread {
		@Override
		public void run() {
			while (!flag) {
				Thread.yield();
			}
			System.out.println(currentThread().getName() + "num =" + num);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0 ; i < 100 ; i ++) {
			new ReadThread().start();
		}
		num = 10;
		flag = true;
	}
	
	
	
}
