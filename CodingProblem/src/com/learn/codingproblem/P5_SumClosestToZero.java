package com.learn.codingproblem;

//https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
public class P5_SumClosestToZero {
	/*
	 * //Simple solution with time complexity as n2 
	 public static void sumClosestToZero(int[] ary1) 
	 { 
	 int l=ary1.length; 
	 int min_l=ary1[0]; 
	 int min_r=ary1[1]; 
	 int sum=ary1[0]+ary1[1]; 
	 for(int i=0;i<l;i++) 
	 { 
	 for(intj=i+1;j<l;j++) 
	 { 
	 if(ary1[0]+ary1[1]<=sum) 
	 { 
	 min_l=ary1[i]; 
	 min_r=ary1[j];
	 }
	 } 
	 }
	  
	 System.out.println("Two elements with sum closest to zero are : "+min_l+" and "+min_r); }
	 */
	public static void sumClosestToZero(int[] ary1) {
		int n = ary1.length;
		//variable l and r are being used to iterate through the loop
		int l=0;
		int r=n-1;
		//varibale index_low and index_high are being used to store index for closest sum
		int index_low = 0;
		int index_high = n - 1;
		int min_sum = ary1[0] + ary1[1];
		int curr_sum;
		ary1 = sort(ary1);
		System.out.println("Sorted Array:");
		for(int i=0;i<n;i++)
		{
			System.out.println(ary1[i]);
		}
		for (; l < r;) {
			curr_sum = ary1[l] + ary1[r];
			if (Math.abs(min_sum) > Math.abs(curr_sum)) 
			{
				min_sum = curr_sum;
				index_low=l;
				index_high=r;
			}
				if (curr_sum > 0) {
					r--;
				} else {
					l++;
				}
		}

		System.out.println("Two elements with sum closest to zero are : "
				+ ary1[index_low] + " and " + ary1[index_high]);
	}

	private static int[] sort(int[] ary1) {
		// TODO Auto-generated method stub
		int l = ary1.length;
		int min_index, min_value;
		for (int i = 0; i < l - 1; i++) {
			min_index = i;
			for (int j = i + 1; j < l; j++) {
				if (ary1[j] < ary1[min_index])
					min_index = j;
			}
			min_value = ary1[min_index];
			ary1[min_index] = ary1[i];
			ary1[i] = min_value;
		}
		return ary1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 1, 60, -10, 70, -80, 85 };
		// sumClosestToZero(array);
		sumClosestToZero(array);
	}

}
