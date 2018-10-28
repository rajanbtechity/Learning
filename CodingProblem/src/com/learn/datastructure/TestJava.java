package com.learn.datastructure;


public class TestJava {


	public static void main(String[] args) {
		
		
		int n=10;
		int k=1;
		int j=1;
		String permutationExists="";
		int[] rsp=new int[n];
		
		if(k>=n)
		{
			permutationExists="NO";
			System.out.println("Block 1");
		}
		else if(k==0)
		{
			permutationExists="YES";
			for(int i=0;i<n;i++)
			{
				rsp[i]=i+1;
			}
			System.out.println("Block 2");
		}
		else
		{
			for(int i=1;i<=n;i++)
			{
				if(i+k<=n)
				{
					rsp[i-1]=i+k;
					System.out.println("Block 3");
				}
				else if(Math.abs(i-j)==k)
				{
					rsp[i-1]=Math.abs(j);
					j++;
					System.out.println("Block 4");
				}
				else
				{
					permutationExists="NO";
					System.out.println("Block 5");
					break;
				}
				
			}
		}
		
		if(permutationExists.equals("NO"))
		{
			System.out.println(-1);
		}

			for(int i=0;i<n;i++)
			{
				System.out.println(rsp[i]);
			}

	
			System.out.println((char)(79)+"O");
	}
	
}