package com.learn.datastructure;

import java.util.LinkedList;

public class LinkedListJava {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void addNode(int data) {

		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			return;
		}
		Node currNode = head;
		while (currNode.next != null)
			currNode = currNode.next;

		currNode.next = new_node;
		return;

	}

	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();

	}

	public void deleteNode(int nodeData) {

		Node currNode = head;
		Node previousNode;
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}

		if (head.data == nodeData) {
			head = currNode.next;
			System.out.println("Node Deleted:-Head Node");
			return;
		}

		{
			while (currNode.next != null) {
				previousNode = currNode;
				currNode = currNode.next;
				if (currNode.data == nodeData) {
					previousNode.next = currNode.next;
					System.out.println("Node With Value "+nodeData+" Deleted");
					return;
				}
			}
			
			System.out.println("Node to be deleted not found");

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListJava l1 = new LinkedListJava();
		int[] ary = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Head before adding node:" + l1.head);
		// Create Linked List with n elements
		for (int i = 0; i < ary.length; i++) {
			l1.addNode(ary[i]);

		}
		l1.printList();
		l1.deleteNode(4);
		l1.deleteNode(10);
		l1.printList();
	}

}
