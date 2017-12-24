package com.learn.codingproblem;

public class P4_MergeSortedArray {
	
	public static int[] mergeArray(int[] arr1,int[]arr2)
	{
		int l1=arr1.length;
		int l2=arr2.length,l=0;
		int[] MergedArray=new int[l1+l2];
		int i=0,j=0,k=0;
		while(i<l1&&j<l2)
		{
			if(arr1[i]<arr2[j])
			{
				MergedArray[k]=arr1[i];
				i++;
				k++;
			}
			else if(arr1[i]>arr2[j])
			{
				MergedArray[k]=arr2[j];
				j++;
				k++;
			}
			
				
		}
		while(i<l1)
		{
			MergedArray[k]=arr1[i];
			i++;
			k++;
		}
		while(j<l2)
		{
			MergedArray[k]=arr2[j];
			j++;
			k++;
		}
		
		System.out.println("Merged Array Element:");
		for(int m=0;m<MergedArray.length;m++)
		{
			System.out.println(MergedArray[m]);
		}
		return MergedArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1={2,4,5,6,7};
		int[] array2={8,9,10,11,12,15};
		
		System.out.println("Merged Array:"+mergeArray(array1,array2));

	}

}
