package com.learn.SortAlgo;

public class SelectionSort {
	
	public static int[] selectionSort(int[] ary)
	{
		int min_index=0,min_value;
		for(int i=0;i<ary.length-1;i++)
		{
			min_index=i;
			for(int j=i+1;j<ary.length;j++)
			{
				if(ary[j]<ary[min_index])
					min_index=j;
			}
			min_value=ary[min_index];
			ary[min_index]=ary[i];
			ary[i]=min_value;
			//System.out.println("ary["+i+"]"+ary[i]);
		}
		
		
		return ary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={7,3,5,4,1,6};
		selectionSort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
	}

}
