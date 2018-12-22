package com.node.practice;

import java.util.HashMap;

public class ListLoop {
	
	/**
	 * 思路1：快慢指针法
	 * 这是最常见的方法。思路就是有两个指针P1和P2，同时从头结点开始往下遍历链表中的所有节点。
	 * P1是慢指针，一次遍历一个节点。
	 * P2是快指针，一次遍历两个节点。
	 * 如果链表中没有环，P2和P1会先后遍历完所有的节点。
	 * 如果链表中有环，P2和P1则会先后进入环中，一直循环，并一定会在在某一次遍历中相遇。
	 * 因此，只要发现P2和P1相遇了，就可以判定链表中存在环。
	 * @param head
	 * @return
	 */
	public static boolean hasLoopV1(Node head) {
		if (head == null) {
			return false;
		}
		Node p1 = head;
		Node p2 = head;
		while (p2.getNext() != null && p2.getNext().getNext() != null) {
			// 遍历一个节点
			p1 = p1.getNext();
			// 遍历两个节点
			p2 = p2.getNext().getNext();
			
			// 已经到链表末尾,说明p2指针已经完成遍历
			if (p2 == null) {
				return false;
			} else if (p2 == p1) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 思路2：足迹法
	 * 顺序遍历链表中所有的节点，并将所有遍历过的节点信息保存下来。如果某个节点的信息出现了两次，则存在环
	 * @param head
	 * @param index
	 * @return
	 */
	private static HashMap<Node, Integer> map = new HashMap<>();
	
	public static boolean hasLoopV2(Node head,int index) {
		if (head == null || head.getNext() == null) {
			return false;
		}
		
		if (map.containsKey(head)) {
			return true;
		} else {
			map.put(head, index);
			return hasLoopV2(head.getNext(), ++ index);
		}
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node2);
		Node head = node1;
		//boolean hasLoop = hasLoopV1(head);
		boolean hasLoop = hasLoopV2(head, 1);
		System.out.println("该链表是否有环 ：" + hasLoop);
	}
	
	
}
