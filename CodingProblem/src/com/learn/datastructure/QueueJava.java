package com.learn.datastructure;

public class QueueJava {
	int front,rear,size;
	int capacity;
	int qArray[];
	
	QueueJava(int capacity)
	{
		this.capacity=capacity;
		this.front=this.rear=this.size=0;
		qArray=new int[capacity];
	}
	
	boolean isEmpty()
	{
	if(size==0)
		return true;
	else
		return false;
				
	}
	
	boolean isFull()
	{
		if(size==capacity)
			return true;
		else
			return false;
	}
	
	public void enqueue(int n)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		this.qArray[this.rear]=n;
		this.rear=this.rear+1;
		this.size++;
	}
	
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		int element=qArray[this.front];
		this.front=this.front+1;
		this.size=this.size-1;
		return element;
	}
	
	public int front()
	{
		return this.front;
	}
	
	public int rear()
	{
		return this.rear;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueJava q1=new QueueJava(10);
		
		for(int i=0;i<10;i++)
		{
			q1.enqueue(i);
		}
		System.out.println("Enqueue");
		for(int i=0;i<q1.qArray.length;i++)
		{
			System.out.print(q1.qArray[i]+" ");
		}
	
		System.out.println();
		System.out.println("Dequeue");
		for(int i=0;i<10;i++)
		{
			System.out.println(q1.dequeue());
		}

	}

}
