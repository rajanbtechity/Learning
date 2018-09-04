package com.learn.codingproblem;

public class P8_LargestSumContigousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary={-2, -3, 4, -1, -2, 1, 5, -3};
		
		int max_sum=Integer.MIN_VALUE,curr_sum=0;
		
		for(int i=0;i<ary.length;i++)
		{
			
			curr_sum=curr_sum+ary[i];
			
			if(max_sum<curr_sum)
			{
				max_sum=curr_sum;
			}
			if(curr_sum<0)
			{
				curr_sum=0;
			}
		}
		System.out.println("Maximum sum is:"+max_sum);
		
		
		

	}

}
