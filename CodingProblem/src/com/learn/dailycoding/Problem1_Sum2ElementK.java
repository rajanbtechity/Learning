package com.learn.dailycoding;
/*
This problem was recently asked by Google.
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
 */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem1_Sum2ElementK {
	public static void main(String[] args) {
		PrintWriter pw=new PrintWriter(System.out,true);
		boolean sumpresent=false;
		// TODO Auto-generated method stub
		int[] ary={10, 15, 3, 7};
		int k=10;
		/*
		pw.println("Method 1");
		Set<Integer> intset=new HashSet<Integer>();
		for(int i=0;i<ary.length;i++)
		{
			intset.add(ary[i]);
		}
		//This method doesn't work for k=20. It returns true but it should return false
		for(int j=0;j<ary.length;j++)
		{
			if(intset.contains(k-ary[j]))
				sumpresent=true;
		}
		pw.println("Sum of 2 elements in the array with sum "+k+" :"+sumpresent);
		*/
		pw.println("Method 2");
		Set<Integer> seen=new HashSet<Integer>();
		
		for(int j=0;j<ary.length;j++)
		{
			if(seen.contains(k-ary[j]))
			{
				sumpresent=true;	
			}
			else{
				seen.add(ary[j]);
			}
		}
		pw.println("Sum of 2 elements in the array with sum "+k+" :"+sumpresent);

	}

}
