package com.rajan.java.multithreading;

public class Lesson3_ContextSwitching{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Thread starting using start method-context switching");
		ContextSwitch obj1=new ContextSwitch();
		ContextSwitch obj2=new ContextSwitch();
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		t1.start();
		t2.start();
		try{
		t1.join();
		t2.join();
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println("Thread starting using run method-NO context switching");
		NoContextSwitch obj3=new NoContextSwitch();
		NoContextSwitch obj4=new NoContextSwitch();
		Thread t3=new Thread(obj1);
		Thread t4=new Thread(obj2);
		t3.run();
		t4.run();

	}

}

class ContextSwitch implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<6;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

/*
Each thread starts in a separate call stack.
Invoking the run() method from main thread, the run() method goes onto the current 
call stack rather than at the beginning of a new call stack.
 */
class NoContextSwitch implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<6;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}