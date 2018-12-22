package com.node.practice;

public class ListReverse {
	
	// 1.1 单链表逆序
	public static Node reverseList(Node head) {
		if (head == null) {
			return null;
		}
		
		if (head.getNext() == null) {
			return head;
		}
		
		// 定义当前节点
		Node curNode = null;
		// 定义下一节点
		Node nextNode = null;
		// 定义前一节点
		Node preNode = null;
		// 将头节点赋值给当前节点
		curNode = head;
		
		while (curNode != null) {
			// 当前下一节点赋值给nextNode
			nextNode = curNode.getNext();
			// 将当前节点的下一节点指向前一节点，实现转向
			curNode.setNext(preNode);
			// 将前一节点，和当前节点均后移一位
			preNode = curNode;
			curNode = nextNode;
		}
		
		return preNode;
	}
	
	public static Node reverseList2(Node head) {
		return reverseListRecursively(null, head);
	}
	
	public static Node reverseListRecursively(Node preNode,Node curNode) {
		if (curNode == null) {
			return null;
		}
		if (curNode.getNext() == null) {
			curNode.setNext(preNode);
			return curNode;
		}
		// 如果当前节点有下一节点，则递归调用
		Node nextNode = curNode.getNext();
		curNode.setNext(preNode);
		Node newNode = reverseListRecursively(curNode, nextNode);
		return newNode;
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		Node head = node1;
		//Node newNode = reverseList(head);
		Node newNode = reverseList2(head);
		
		System.out.println("第一节点：" + newNode.getData()
						+ "第二节点：" + newNode.getNext().getData()
						+ "第三节点：" + newNode.getNext().getNext().getData()
						+ "第四节点：" + newNode.getNext().getNext().getNext().getData());
	}
}
