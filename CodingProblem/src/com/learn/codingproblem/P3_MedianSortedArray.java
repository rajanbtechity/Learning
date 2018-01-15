package com.learn.codingproblem;

import java.util.Arrays;

import com.learn.codingproblem.P4_MergeSortedArray;

//https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
/*
 * implementation 1 - Merge both the array using merge sort. Find minimum of two elements and copy in the new array
 * implementation 2 - Use Merge sort approach. We need to pick nth and n-1th index element. So keep picking minimum of two
 * elements and assign it to m2. Copy old minimum to m1. If all elements of array1 is not smaller than that of array2 
 * or vice versa then one of m1/m2 will in array1 and other will be in array2
 * What if all elements of array1 is smaller than that of array2..with below logic we will end up searching ar1[n]
 * as we are picking smaller one which will give index out of bound exception. if you think when i 
 * becomes n(mid of sum of length of both the array) it means all elements in array1 is smaller than that of array2.
 * So in that case pick the last element of array and first element of array2.
 * m1=m2 and m2=array2[0]
 * implementation 3 - Use divide and conquer rule to reduce size of the array to search.
 */
public class P3_MedianSortedArray {

	public static int getMedian(int[] ar1, int[] ar2) {
		int i = 0;
		int j = 0;
		int m1 = 0;
		int m2 = 0;
		int n = (ar1.length + ar2.length) / 2;
		for (int count = 0; count <= n; count++) {
			if (i == n) {
				m1 = m2;
				m2 = ar2[0];
				break;
			} else if (j == n) {
				m1 = m2;
				m2 = ar1[0];
			} else if (ar1[i] < ar2[j]) {
				/* Store the prev median */
				m1 = m2;
				m2 = ar1[i];
				i++;
			} else if (ar1[i] > ar2[j]) {
				/* Store the prev median */
				m1 = m2;
				m2 = ar2[j];
				j++;
			}

		}

		return (m1 + m2) / 2;
	}

	/*
	public static int getMedian(int[] ar1, int[] ar2, int n) {
		int m1 = median(ar1);
		int m2 = median(ar2);
		System.out.println("Elements of Array1:" + Arrays.toString(ar1));
		System.out.println("Elements of Array2:" + Arrays.toString(ar2));
		if (n <= 0)
			return -1;
		else if (n == 1) {
			return (ar1[0] + ar2[0]) / 2;
		} else if (m1 == m2) {
			return m1;
		} else if (n == 2) {
			return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;
		}
		// 2,4,6,8,10
		// 3,5,7,9,11
		else if (m1 > m2) {
			System.out.println("m1>m2 Block");
			if (n % 2 != 0)
				return getMedian(Arrays.copyOfRange(ar1, 0, n / 2+1),
						Arrays.copyOfRange(ar2, n / 2, n), n / 2 + 1);
			else
				return getMedian(Arrays.copyOfRange(ar1, 0, n / 2+1),
						Arrays.copyOfRange(ar2, n / 2 - 1, n / 2), n / 2 + 1);

		} else {
			System.out.println("m1<m2 Block with n:"+n);
			if (n % 2 != 0)
				return getMedian(Arrays.copyOfRange(ar1, n / 2, n),
						Arrays.copyOfRange(ar2, 0, n / 2 + 1), n / 2+1);
			else
				return getMedian(Arrays.copyOfRange(ar1, n / 2 - 1, n),
						Arrays.copyOfRange(ar2, 0, n / 2+1), n / 2 + 1);

		}
	}
	*/
	
	public static int getMedian(int[] ar1, int[] ar2, int n) {
		int start_a,end_a,start_b,end_b;
		int m1 = median(ar1);
		int m2 = median(ar2);
		System.out.println("Elements of Array1:" + Arrays.toString(ar1));
		System.out.println("Elements of Array2:" + Arrays.toString(ar2));
		if (n <= 0)
			return -1;
		else if (n == 1) {
			return (ar1[0] + ar2[0]) / 2;
		} else if (m1 == m2) {
			return m1;
		} else if (n == 2) {
			return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;
		}
		// 2,4,6,8,10
		// 3,5,7,9,11
		else if (m1 > m2) {
			System.out.println("m1>m2 Block");
			if (n % 2 != 0)
				return getMedian(Arrays.copyOfRange(ar1, 0, n / 2+1),
						Arrays.copyOfRange(ar2, n / 2, n), n / 2 + 1);
			else
				return getMedian(Arrays.copyOfRange(ar1, 0, n / 2+1),
						Arrays.copyOfRange(ar2, n / 2 - 1, n / 2), n / 2 + 1);

		} else {
			System.out.println("m1<m2 Block with n:"+n);
			if (n % 2 != 0)
				return getMedian(Arrays.copyOfRange(ar1, n / 2, n-1),
						Arrays.copyOfRange(ar2, n/2, n-1), n / 2+1);
			else
				return getMedian(Arrays.copyOfRange(ar1, n / 2 - 1, n),
						Arrays.copyOfRange(ar2, 0, n / 2+1), n / 2 + 1);

		}
	}

	public static int median(int[] ary) {
		int l = ary.length;
		if (l % 2 == 0) {
			return (ary[l / 2 - 1] + ary[l / 2]) / 2;
		} else
			return ary[l / 2];

	}

	public static int max(int n1, int n2) {
		if (n1 >= n2)
			return n1;
		else
			return n2;
	}

	public static int min(int n1, int n2) {
		if (n1 <= n2)
			return n1;
		else
			return n2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 5, 10, 11, 17,19 };
		int[] array2 = { 6, 8, 12, 15, 18,20 };
		int l1 = array1.length;
		int l2 = array2.length;
		/*
		 * //first merge the array and then find the median int
		 * l1=array1.length; int l2=array2.length; int[] mergedArray=new
		 * int[l1+l2]; mergedArray=P4_MergeSortedArray.mergeArray(array1,
		 * array2); int m=((l1+l2)-1)/2; int
		 * median=(mergedArray[m]+mergedArray[m+1])/2;
		 */
		int median = getMedian(array1, array2);
		System.out.println("Using Merge Sort technique Median is : " + median);
		median = getMedian(array1, array2, l1);
		System.out.println("Using Divide and Conquer Technique Median is : "
				+ median);

	}

}
