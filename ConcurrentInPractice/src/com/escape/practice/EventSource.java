package com.escape.practice;

import java.util.ArrayList;
import java.util.List;

/**
 *	事件源
 * @param <T>
 */
public class EventSource<T> {
	private final List<T> eventListeners;
	public EventSource() {
		eventListeners = new ArrayList<>();
	}
	
	/**
	 * 注册监听器
	 * @param eventListener
	 */
	public synchronized void registerListener(T eventListener) {
		this.eventListeners.add(eventListener);
		this.notifyAll();
	}
	
	/**
	 * 获取监听器集合
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized List<T> retrieveListeners() throws InterruptedException {
		List<T> dest = null;
		if (eventListeners.size() <= 0) {
			this.wait();
		}
		dest = new ArrayList<>(eventListeners.size());
		dest.addAll(eventListeners);
		return dest;
		
	}
}
