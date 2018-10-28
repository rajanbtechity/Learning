package com.learn.codingproblem;

public class P12_QueueUsingStack {
	JavaStack s1 = new JavaStack();
	JavaStack s2=  new JavaStack();
	
	public void enQueue(int n)
	{
		if(s1.top>=s1.a.length)
		{
			System.out.println("Queue is full");
			return;
		}
		s1.push(n);
	}
	
	public int deQueue()
	{
		//System.out.println("Stack 2 top:"+s2.top);
		if(s1.top==-1 && s2.top==-1)
		{
			System.out.println("Queue is Empty");
			return -1;
		}
		else if(s2.top==-1)
		{
			//System.out.println("s1.top="+s1.top);
			int s1Top=s1.top;
		for(int i=0;i<=s1Top;i++)
		{
			//System.out.println("Pushing to stack 2");
			s2.push(s1.pop());
		}
		}
		//System.out.println("s2.top:"+s2.top);
		
		return s2.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		P12_QueueUsingStack q=new P12_QueueUsingStack();
		
		System.out.println(q.deQueue());
		q.enQueue(10);
		q.enQueue(11);
		q.enQueue(12);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());


	}

}

class JavaStack {
	int[] a = new int[10];
	int top = -1;

	public void push(int n) {
		if (top >= a.length - 1) {
			System.out.println("Stack is full");
			return;
		}
		top++;
		a[top] = n;
		//System.out.println("Item :"+n+" added at pos:"+top);
	}

	public int pop() {
		if (top < 0) {
			System.out.println("Stack is empty");
			return -1;
		}
		return a[top--];
	}

	public void peek() {
		System.out.println(a[top]);
	}

}
