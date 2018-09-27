package com.learn.datastructure;

class Node {
	Node next;
	int data;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class QueueJava2 {
	Node front, rear;

	QueueJava2() {
		front = null;
		rear = null;
	}

	void enqueue(int key) {
		Node tmp = new Node(key);
		if (rear == null) {
			front = rear = tmp;
			return;
		}
		rear.next = tmp;
		rear = tmp;
	}

	void printQueue() {
		Node currNode = front;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	Node deQueue()
	{
		if(front==null)
		{
			return null;
		}
		
		Node temp=front;
		front=front.next;
		
		return temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		QueueJava2 q1 = new QueueJava2();
		System.out.println("Enqueue");
		for (int i = 0; i < ary.length; i++) {
			q1.enqueue(ary[i]);
		}
		System.out.println("Print Queue");

		q1.printQueue();
		System.out.println();
		System.out.println("Dequeue");
		for (int i = 0; i < ary.length; i++) {
			System.out.println(q1.deQueue().data);
		}

	}

}
