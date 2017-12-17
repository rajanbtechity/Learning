package com.learn.SearchAlgo;

public class LinearSearch {
	
	
	public static int LinearSearch(int[] arry,int x)
	{
		for(int i=0;i<arry.length;i++)
		{
			if(arry[i]==x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={2,3,4,5,6,7,8,9};
		int index=LinearSearch(array,8);
		{
			if(index==-1)
				System.out.println("Element not found");
			
			else
				System.out.println("Element Found at index:"+index);
			
		}

	}

}
