package com.learn.SearchAlgo;

public class BinarySearch {

	public static int BinarySearch(int[] arry,int x)
	{
		int l=0,h=arry.length-1,m=0;

		while(l<=h)
		{
			m=l+((h-l)/2);
			if(arry[m]==x)
				return m;
			else if(x>arry[m])
					l=m+1;
				else
					h=m-1;
		}
		
		return -1;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting");
		int[] array={1,2,3,4,5,6,7,8,9};
		int index=BinarySearch(array,5);
		{
			if(index==-1)
				System.out.println("Element not found");
			
			else
				System.out.println("Element Found at index:"+index);
			
		}

	}

}
