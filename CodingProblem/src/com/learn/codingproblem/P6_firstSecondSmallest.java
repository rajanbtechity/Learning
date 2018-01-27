package com.learn.codingproblem;

public class P6_firstSecondSmallest {

	/*
	//This is simple way. Sort the array and get first two elements.
	public static void getFirstSecondSmall(int[] ary)
	{
		selectionSort(ary);
		System.out.println("First Smallest Element:"+ary[0]);
		System.out.println("Second Smallest Element:"+ary[1]);
	}
	*/
	
	/*
	//Traverse the array 2 times. in first iteration get smallest element and second smallest element in second
	//iteration
	public static void getFirstSecondSmall(int[] ary)
	{
		int low1=ary[0];
		int n=ary.length;
		for(int i=0;i<n;i++)
		{
			if(ary[i]<low1)
			{
				low1=ary[i];
			}
		}
		int low2=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			if(ary[i]!=low1 && ary[i]>low1 && ary[i]<=low2)
			{
				low2=ary[i];
			}
		}
		System.out.println("First Smallest element:"+low1);
		System.out.println("Second Smallest element:"+low2);
		
	}
	public static int[] selectionSort(int[] ary)
	{
		int n=ary.length;
		int min_index;
		int min_value;
		
		//1,3,2
		
		for(int i=0;i<n-1;i++)
		{
			min_index=i;
			for(int j=i;j<n;j++)
			{
				if(ary[j]<ary[i])
				{
					min_index=j;
				}
			}
			min_value=ary[min_index];
			ary[min_index]=ary[i];
			ary[i]=min_value;
		}
		
	
		return ary;
	}
	*/
	
	public static void getFirstSecondSmall(int[] ary)
	{
		int low1=Integer.MAX_VALUE;
		int low2=Integer.MAX_VALUE;
		
		for(int i=0;i<ary.length;i++)
		{
			if(ary[i]<low1)
			{
				low2=low1;
				low1=ary[i];
			}
			else if(ary[i]<low2)
			{
				low2=ary[i];
			}
			
		}
		
		System.out.println("First smallest element is:"+low1);
		System.out.println("Second smallest element is:"+low2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={-1,-10,2,3,6,1,4,5,10};
		getFirstSecondSmall(array);

	}

}
