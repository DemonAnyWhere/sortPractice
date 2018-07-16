package com.atomic.practice;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class PracticeAtomic {

	@Test
	public void testAll() {
		final AtomicInteger value = new AtomicInteger(10);
		assertEquals(value.compareAndSet(1, 2), false); //10
		System.out.println(value.get());
		assertEquals(value.compareAndSet(10, 20), true); //20
		System.out.println(value);
		value.set(0); //0
		System.out.println(value);
		//
		int incrementAndGet = value.incrementAndGet(); //1
		System.out.println(incrementAndGet); // 1
		assertEquals(value.incrementAndGet(), 2); //2
		System.out.println(value.get()); //2
		int andIncrement = value.getAndIncrement();
		System.out.println(andIncrement); //2
		System.out.println(value.get()); //3
		//
		int andAdd = value.getAndAdd(2);
		System.out.println(andAdd); //3
		System.out.println(value);  //5
		int andSet = value.getAndSet(6);
		System.out.println(andSet); // 5
		System.out.println(value.get()); //6
	}
}
