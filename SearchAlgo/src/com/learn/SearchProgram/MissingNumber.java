package com.learn.SearchProgram;

/*
 //http://www.geeksforgeeks.org/find-the-missing-number/
 //There are two ways
 //1. Find Sum of all elements in current array and then find sum of 1 to n+1 elements using 
 //formula and substract.
 //2. Find xor of all elements in the array(x1) and then xor of 1 to n+1 elements(x2)
 //xor of x1 and x2 gives the missing number
 */
public class MissingNumber {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={1,2,3,4,6,7,8,9};
		//System.out.println("Missing number:"+MissingNum(array));

	}

}
