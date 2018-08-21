package com.escape.practice;

import java.util.concurrent.TimeUnit;

/**
 * 模拟this逃逸
 */
public class ThisEscape {
	public final int id;
	public final String name;
	public ThisEscape(EventSource<AEventListener> eventSource) {
		id = 1;
		eventSource.registerListener(new AEventListener() {
			
			@Override
			public void event(Object object) {
				System.out.println("id :" + ThisEscape.this.id);
				System.out.println("name :" + ThisEscape.this.name);
			}
		});
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		name = "thisEscape test.";
	}
	
	
	public static void main(String[] args) {
		EventSource<AEventListener> eventSource = new EventSource<AEventListener>();
        ListenRunnable listenerRunnable = new ListenRunnable(eventSource);
        new Thread(listenerRunnable).start();
        System.out.println();
        ThisEscape escape = new ThisEscape(eventSource);
        System.out.println(escape);
	}
}	
