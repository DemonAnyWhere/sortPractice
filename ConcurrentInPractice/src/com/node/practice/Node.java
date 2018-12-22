package com.node.practice;

public class Node {
	// 数据域存储数据
	private int data;
	
	// 指针域存储下一节点地址
	private Node next;
	
	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
