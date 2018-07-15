package com.learn.dailycoding;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;



public class Problem7_NumOfWaysDecode {

	static int countDecoding(char[] digits, int n) 
	{
	    // base cases
	    if (n == 0 || n == 1)
	    return 1;
	 
	    // Initialize count
	    int count = 0; 
	 
	    // If the last digit is not 0, then 
	    // last digit must add to
	    // the number of words
	    if (digits[n - 1] > '0')
	    count = countDecoding(digits, n - 1);
	 
	    // If the last two digits form a number
	    // smaller than or equal to 26,
	    // then consider last two digits and recur
	    if (digits[n - 2] == '1' || 
	       (digits[n - 2] == '2' && digits[n - 1] < '7'))
	    count += countDecoding(digits, n - 2);
	 
	    return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    char digits[] = {'1', '2', '3', '4'};
		    int n = digits.length;
		    System.out.printf("Count is %d", countDecoding(digits, n));

	}

}