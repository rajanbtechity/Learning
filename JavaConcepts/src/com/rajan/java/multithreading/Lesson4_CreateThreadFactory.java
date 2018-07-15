package com.rajan.java.multithreading;

class NewThread implements Runnable
{
	private static int cnt=0;
	Thread t;

	NewThread()
	{
		cnt++;
		System.out.println("this:"+this);
		this.t=new Thread(this,"Child Thread "+this);
	}
	
	public static int getCnt()
	{
		return cnt;
	}
	public static NewThread createAndStart()
	{
		NewThread mythrd=new NewThread();
		mythrd.t.start();
		return mythrd;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Child Thread started");
	}
	
}


public class Lesson4_CreateThreadFactory {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewThread obj1=new NewThread().createAndStart();
		//obj1.t.start();
		System.out.println("Getting obj1 t name:"+obj1.t.getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println("cnt"+NewThread.getCnt());

	}

}
