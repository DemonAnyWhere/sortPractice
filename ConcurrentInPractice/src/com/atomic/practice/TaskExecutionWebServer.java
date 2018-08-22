package com.atomic.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
	private static final int NTHREAD = 10;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREAD);
	
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while (true) {
			Socket connection = socket.accept();
			Runnable task = new Runnable() {
				@Override
				public void run() {
					//doSomething....
				}
			};	
			exec.execute(task);
		}
	}
}
