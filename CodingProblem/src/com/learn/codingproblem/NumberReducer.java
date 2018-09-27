package com.learn.codingproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class NumberReducer {

	static int totalWays=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reduce(6));
	}
	
	static int reduce(int n) {
        /*
         * Write your code here.
         */
        /*
        Points to consider
        1. Negative numbers can be expressed as  product of positive and negative..keep reducing positive number
        2. Find factors of n
        3. if n=0,1,2,3 return n
        */
        
       if(n<0)
       {
           return -1;
       }
        if(n==0||n==1||n==2||n==3)
        {
        	System.out.println("Returning"+n);
        	totalWays=totalWays+n;
        	return totalWays;
        }
        
        int factor1=1;
        int factor2=1;
        for(int i=1;i*i<n;i++)
        {
            if(n%i==0)
            {
                factor1=i;
                factor2=n/i;
            }
        }
    	System.out.println("factor1:"+factor1+" factor2:"+factor2);

        if(factor1!=1 && factor2!=n)
        {
            ++totalWays;
            reduce(Math.max(factor1,factor2));
            
        }
        else{
            ++totalWays;
            reduce(n-1);
        }
        
        return totalWays;

    }

}
