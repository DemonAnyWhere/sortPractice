package com.node.practice;

public class ListFind {
	/**
	 * 为了能够只遍历一次就能找到倒数第k个节点，可以定义两个指针：
　　	 *（1）第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；
　　     *（2）从第k步开始，第二个指针也开始从链表的头指针开始遍历；
　　     *（3）由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k个结点。
	 */
	public static Node findOpsOne(Node node,int n) {
		if (node == null || n == 0) {
			return null;
		}
		Node ahead = node;
		Node behind = null;
		
		for (int i = 0; i < n -1; i ++) {
			if (ahead.getNext() != null) {
				ahead = ahead.getNext();
			} else {
				return null;
			}
		}
		
		behind = node;
		while (ahead.getNext() != null) {
			ahead = ahead.getNext();
			behind = behind.getNext();
		}
		
		return behind;
	}
	
	
	/**
	 * 寻找链表的中间节点
	 * 思路：快慢指针法
	 * @param node
	 * @return
	 */
	public static Node findMid(Node node) {
		if (node == null) {
			return null;
		}
		if (node.getNext() == null) {
			return node;
		}
		
		Node p1 = node;
		Node p2 = node;
		
		while (p2.getNext() != null && p2.getNext().getNext() != null) {
			p1 = p1.getNext();
			p2 = p2.getNext().getNext();
			
		}
		return p1;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		//Node node7 = new Node(7);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		//node6.setNext(node7);
		Node head = node1;
		Node findOpsOne = findOpsOne(head, 3);
		Node findMid = findMid(head);
		System.out.println("倒数第3个节点是 ：" + findOpsOne.getData());
		System.out.println("中间节点是：" + findMid.getData());
	}
	
}
