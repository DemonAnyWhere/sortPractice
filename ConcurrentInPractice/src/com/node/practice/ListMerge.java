package com.node.practice;

public class ListMerge {
	public static Node mergeTwoLists(Node node1, Node node2) {
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		
		Node head = null;
		if (node1.getData() <= node2.getData()) {
			head = node1;
			head.setNext(mergeTwoLists(node1.getNext(), node2));
		} else {
			head = node2;
			head.setNext(mergeTwoLists(node1, node2.getNext()));
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(1);
		Node node5 = new Node(3);
		Node node6 = new Node(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node4.setNext(node5);
		node5.setNext(node6);
		Node nodeL = node1;
		Node nodeR = node4;
		Node newNode = mergeTwoLists(nodeL, nodeR);
		StringBuilder sBuilder = new StringBuilder();
		while (newNode != null) {
			sBuilder.append(newNode.getData() + "-->");
			newNode = newNode.getNext();
		}
		System.out.println("链表合并结果为 ：" + sBuilder.toString());
	}
	
}
