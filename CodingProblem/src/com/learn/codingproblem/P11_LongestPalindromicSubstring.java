package com.learn.codingproblem;

public class P11_LongestPalindromicSubstring {
	static void printSubStr(String str, int low, int high) { 
        System.out.println(str.substring(low, high + 1)); 
    } 
    static int longestPalSubstr(String str) { 
        int n = str.length();
        int table[][] = new int[n][n]; 
        int maxLength = 1; 
        for (int i = 0; i < n; ++i) 
            table[i][i] = 1; 
        
        int start = 0; 
        for (int i = 0; i < n - 1; ++i) { 
            if (str.charAt(i) == str.charAt(i + 1)) { 
                table[i][i + 1] = 1; 
                start = i; 
                maxLength = 2; 
            } 
        } 
        
        for (int k = 3; k <= n; ++k) { 
            for (int i = 0; i < n - k + 1; ++i)  
            { 
                int j = i + k - 1; 
     if (table[i + 1][j - 1]==1 && str.charAt(i) == str.charAt(j)) { 
                    table[i][j] = 1; 
  
                    if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        }
        
        for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				System.out.print(table[i][j]+" ");
			}
			System.out.println();

		}
        
        System.out.print("Longest palindrome substring is; "); 
        printSubStr(str, start, start + maxLength - 1); 
          
        return maxLength; // return length of LPS 
    } 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "GeeksforGeeks";
		String str2 = "GeeksQuiz";
		int n=0,m=0;
		int[][] matrix2=new int[str1.length()][str1.length()];
		
		 String str = "abba"; 
	     System.out.println("Length is: "+longestPalSubstr(str));
		
		
		/*
		for(int i=0;i<str1.length();i++)
		{ 
			for(int j=0;j<str1.length();j++)
			{
				if(str1.charAt(i)==str1.charAt(j))
				{
					matrix2[i][j]=1;
				}
			}
		}
		
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				System.out.print(matrix2[i][j]+" ");
			}
			System.out.println();

		}
		*/

	}

}
