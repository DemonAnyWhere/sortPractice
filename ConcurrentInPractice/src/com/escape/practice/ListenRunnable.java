package com.escape.practice;

import java.util.List;

/**
 *	监听器线程
 */
public class ListenRunnable implements Runnable {
	
	private EventSource<AEventListener> source;
	
	public ListenRunnable(EventSource<AEventListener> source) {
		this.source = source;
	}
	
	@Override
	public void run() {
		List<AEventListener> listeners = null;
		
		try {
			listeners = source.retrieveListeners();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (AEventListener eventListener : listeners) {
			eventListener.event(new Object());
		}
		
	}
	
}
