package com.learn.codingproblem;

public class P1_MissingNumber {
	/*
	 //Method 1
	public static int MissingNum(int[]ary)
	{
		int n =ary.length;
		int total=((n+1)*(n+2))/2;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+ary[i];
		}
		
		return total-sum;
	}
	*/

	public static int MissingNum(int[]ary)
	{
		int n =ary.length;
		int x2=0;
		int x1=0;
		for(int i=0;i<n;i++)
		{
			x1=x1^ary[i];
		}

		for(int i=1;i<=n+1;i++)
		{
			x2=x2^i;
		}

		
		return x1^x2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={1,2,3,4,6,7,8,9};
		System.out.println("Missing number:"+MissingNum(array));

	}

}
