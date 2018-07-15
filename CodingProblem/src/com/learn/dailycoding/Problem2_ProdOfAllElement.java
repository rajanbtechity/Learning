package com.learn.dailycoding;
/*
This problem was asked by Uber.
Given an array of integers, return a new array such that each element at index i of the new array is the product 
of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 If our input was [3, 2, 1], the expected output would be [2, 3, 6].
Follow-up: what if you can't use division?
*/
import java.io.PrintWriter;

public class Problem2_ProdOfAllElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(System.out, true);
		int[] ary={1, 2, 3, 4, 5};
		int n=ary.length;
		/*
		//We don't have to use multiplication
		pw.println("Method 1");
		for(int i=0;i<ary.length;i++)
		{
			prodAllElement*=ary[i];
		}
		
		for(int j=0;j<ary.length;j++)
		{
			ary[j]=prodAllElement/ary[j];
		}
		
		for(int i=0;i<ary.length;i++)
		{
			pw.println(ary[i]);	
		}
		*/
		
		int[] prefixAry=new int[n];
		int[] suffixAry=new int[n];
		
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				prefixAry[i]=1;
			}
			else
			{
				prefixAry[i]=prefixAry[i-1]*ary[i-1];
			}
		}
		
		for(int i=n-1;i>=0;i--)
		{
			if(i==n-1)
			{
				suffixAry[i]=1;
			}
			else
			{
				suffixAry[i]=suffixAry[i+1]*ary[i+1];
			}
		}
		
		for(int i=0;i<n;i++)
		{
			pw.println(prefixAry[i]*suffixAry[i]);
		}

	}

}
