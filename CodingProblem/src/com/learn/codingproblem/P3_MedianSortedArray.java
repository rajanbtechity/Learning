package com.learn.codingproblem;

public class P3_MedianSortedArray {
	/*
	public static int[] mergeArray(int[] arr1,int[]arr2)
	{
		int l1=arr1.length;
		int l2=arr2.length,l=0;
		int[] MergedArray=new int[l1+l2];
		for(int i=1;i<=l1;)
		{
			System.out.println("i:"+i);
			for(int j=0;j<i;)
			{
				System.out.println("j:"+j);
				System.out.println("arr1["+(i-1)+"]");
				if(arr1[i-1]<arr2[j])
				{
					MergedArray[l]=arr1[i-1];
					i++;
					l++;
					System.out.println("after increment i"+i);
					break;
				}
				else if(arr1[i-1]>arr2[j])
				{
					MergedArray[l]=arr2[j];
					j++;
					l++;
				}
			}
		}
		
		System.out.println("Merged Array Element:");
		for(int i=0;i<MergedArray.length;i++)
		{
			System.out.println(MergedArray[i]);
		}
		
		return MergedArray;
		
	}
	*/
	public static int[] mergeArray(int[] arr1,int[]arr2)
	{
		int l1=arr1.length;
		int l2=arr2.length,l=0;
		int[] MergedArray=new int[l1+l2];
		
		return MergedArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1={2,4,5,6,7};
		int[] array2={8,9,10,11,12};
		
		System.out.println("Merged Array:"+mergeArray(array1,array2));

	}

}
