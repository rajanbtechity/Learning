package com.learn.dailycoding;
/*
This problem was asked by Stripe.
Given an array of integers, find the first missing positive integer in linear time and constant space. 
In other words, find the lowest positive integer that does not exist in the array. 
The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
*/
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Problem3_MissingPositiveNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter pw=new PrintWriter(System.out, true);
		int[] ary1={0,1,2};
		//{};
		Set<Integer> set1=new HashSet<Integer>();
		int max=ary1[0];
		for(int i=0;i<ary1.length;i++)
		{
			set1.add(ary1[i]);
			if(ary1[i]>max)
			{
				max=ary1[i];
			}
		}
		
		System.out.println("Max is:"+max);
		int missing_num=max+1;
		// This method uses O(N) space
		for(int i=1;i<=missing_num;i++)
		{
			if(!set1.contains(i))
			{
				System.out.println("First missing positive integer is:"+i);
				break;
			}
		}
		int tmp;
		for(int i=0;i<ary1.length;)
		{
			if(ary1[i]!=i+1 && ary1[i]>0)
			{
				tmp=ary1[ary1[i]-1];
				ary1[ary1[i]-1]=ary1[i];
				ary1[i]=tmp;
			}
			
			if(ary1[i]<=0 || ary1[i]==(i+1) || ary1[i]>ary1.length)
			{
				i++;
			}
		}
		
		for(int i=0;i<ary1.length;i++)
		{
			if(ary1[i]!=i+1)
			{
				System.out.println("Second Approach-First missing positive integer is:"+(i+1));
			}
		}
		

	}

}
