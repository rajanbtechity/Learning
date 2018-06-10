package com.rajan.java.multithreading;

public class Lesson2_CreateThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread running:"+Thread.currentThread().getName());
		System.out.println("Thread priority:"+Thread.currentThread().getPriority());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lesson2_CreateThread2 ob1=new Lesson2_CreateThread2();
		Thread t1=new Thread(ob1);
		t1.start();
		t1.setName("This is thread 1");

	}

	

}
