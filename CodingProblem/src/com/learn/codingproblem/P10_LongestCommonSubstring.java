package com.learn.codingproblem;

public class P10_LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "GeeksforGeeks";
		String str2 = "GeeksQuiz";
		int n=0,m=0;
		int[][] matrix2=new int[str1.length()][str1.length()];

		int[][] matrix = new int[str1.length()][str2.length()];
		int max = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if ((i == 0 || j == 0)) {
					if (str1.charAt(i) == str2.charAt(j))
						matrix[i][j] = 1;
						
				} else if (str1.charAt(i)==str2.charAt(j)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
					if (max < matrix[i][j]) {
						max = matrix[i][j];
						n=i;
						m=j;
					}
				}
			}
		}
		
		System.out.println(str1.substring((n-max)+1, max));
		
		/*
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();

		}
		*/

		System.out.println(max);

	}

}
