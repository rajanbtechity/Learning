package com.learn.codingproblem;

public class P9_Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P9_Power p1=new P9_Power();
		System.out.println(p1.calPower(2, 5));
	}
	
	public int calPower(int x,int y)
	{
		if(y==0)
		{
			return 1;
		}
		int pow=1;
		int temp=calPower(x,y/2);
		if(y%2==0)
		{
			pow=temp*temp;
		}
		else
		{
			pow=x*temp*temp;
		}
		System.out.println("Returning:"+pow);
		return pow;
		
	}

}
