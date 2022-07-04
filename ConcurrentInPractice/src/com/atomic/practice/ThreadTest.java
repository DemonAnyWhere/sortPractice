package com.atomic.practice;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

	public static void main(String[] args) {
		Person personA = new Person();
		Person personB = new Person();
		
		
		
		
		for (int i = 0; i < 10; i++) {
			new ThreadTaskA(personA).start();
			
		}
		

		for (int i = 0; i < 10; i++) {
			new ThreadTaskB(personA).start();
			
		}
		
		System.out.println("主线程输出：" + personA.getNext());
	}
	
	
	
	
}

class Person {
	private int value;
	private int age;
	public synchronized int getNext() {
		return value ++  ;
	}
	
}

class ThreadTaskA extends Thread {
	private Person person;
	public ThreadTaskA(Person person) {
		this.person = person;
	}
	
	@Override
	public void run() {
		System.out.println("线程A输出：" + person.getNext());
	}
	
}


class ThreadTaskB extends Thread {
	private Person person;
	public ThreadTaskB(Person person) {
		this.person = person;
	}
	
	@Override
	public void run() {
		System.out.println("线程B输出：" + person.getNext());
	}
	
}