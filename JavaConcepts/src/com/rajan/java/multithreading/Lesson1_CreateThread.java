package com.rajan.java.multithreading;

import java.util.Date;

public class Lesson1_CreateThread extends Thread {

	public void run()
	{
		Date d=new Date();
		//System.out.println("Thread start time:"+d.getTime());
		System.out.println("Thread running.."+Thread.currentThread().getName()+" Time:"+d.getTime());
		System.out.println("Thread Priority is:"+Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lesson1_CreateThread t1= new Lesson1_CreateThread();
		Lesson1_CreateThread t2= new Lesson1_CreateThread();
		Lesson1_CreateThread t3= new Lesson1_CreateThread();
		t1.start();
		t2.setPriority(4);
		t2.start();
		t3.setPriority(MAX_PRIORITY);
		t3.start();
		
		

	}

}
