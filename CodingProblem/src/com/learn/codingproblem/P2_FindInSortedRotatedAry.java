package com.learn.codingproblem;
//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class P2_FindInSortedRotatedAry {

	public static int findPivot(int[]ary)
	{
		int l=0,m,h=ary.length-1;
		while(l<=h)
		{
			m=l+(h-l)/2;
			if(l==h)
				return l;
			if(ary[m]>ary[m+1] && ary[m]>l)
				return m;
			if(ary[m]<ary[m-1]&& ary[m]<h)
				return m-1;
			if(ary[l]>=ary[m])
				h=m-1;
			else
				l=m+1;
			
		}
		
		return -1;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={7,8,1,2,3,5,6};
		int pivot=findPivot(array);
		System.out.println("Pivot:"+pivot);

	}

}
