package com.learn.codingproblem;

import java.io.*;

public class P7_Permutation {
	public  static int[] tempAry;
	
    public static void main (String[] args) {
    	P7_Permutation obj1=new P7_Permutation();
        int arr[] = {1, 2, 3, 4, 5};
        int r;
        for(int i=0;i<=arr.length;i++)
        {
        	r=i;
        	obj1.tempAry=new int[r];
        	System.out.println("Set with "+i+" elements");
            obj1.printCombination1(arr,0,r,0);
        }
    }
    
    public void printCombination1(int ary[],int start,int r,int index)
    {
    	if(index==r)
    	{
    		for(int i=0;i<r;i++)
    		{
    			System.out.print(tempAry[i]+" ");
    		}
    		System.out.println();
    		return;
    	}
 
    	for(int i=start;i<ary.length;i++)
    	{
    		tempAry[index]=ary[i];
    		printCombination1(ary,i+1,r,index+1);
    	}
    }
}
