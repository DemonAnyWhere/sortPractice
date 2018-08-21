package com.atomic.practice;

import java.util.concurrent.CountDownLatch;

/**
 *	countDownLatch实现闭锁同步器
 *	countDown()方法对计算器做减1操作
 *	await()方法等待计数器达到零，非零则阻塞直到计数器为零
 */
public class TestHarness {
	public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i <nThreads; i ++) {
			Thread t = new Thread(){
				@Override
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			};
			t.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}
}
