package com.atomic.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * demo展示了限制(private关键字)和锁 如何协同确保一个类的线程安全性
 * 	非线程安全的类HashSet管理着ThreadSafeDemo的状态
 * 	不过mySet是私有的，不会逸出，因此mySet被限制在ThreadSafeDemo中。
 *  唯一可以访问mySet的代码路径是addString和containsString，执行它们都要获得ThreadSafeDemo的锁
 *  ThreadSafeDemo的内部锁保护了它所有的状态，因此确保了ThreadSafeDemo是线程安全的。
 * 
 */
public class ThreadSafeDemo {
	private final Set<String> mySet = new HashSet<>();
	
	public synchronized void addString(String str) {
		mySet.add(str);
	}
	
	public synchronized boolean containsString(String str) {
		return mySet.contains(str);
	}
	
}
