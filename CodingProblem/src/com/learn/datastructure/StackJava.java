package com.learn.datastructure;

import java.io.PrintWriter;

public class StackJava {
	int ary[]=new int[10];
	int top=-1;
	
	public String push(int n)
	{
		if(top>=ary.length-1)
		{
			return "Stack full";
		}
		
			ary[++top]=n;
			return "Pushed:"+n;
				
	}
	
	public String pop()
	{
		if(top==-1)
		{
			return "Stack Empty";
		}
		return Integer.toString(ary[top--]);
	}
	
	public String peek()
	{
		if(top>=0)
		{
			return Integer.toString(ary[top]);
		}
		else
			return "Stack Empty";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackJava s1=new StackJava();
		PrintWriter pw=new PrintWriter(System.out,true);
		int ary[]={1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<ary.length;i++)
		{
			pw.println(s1.push(ary[i]));
		}
		
		for(int i=0;i<ary.length;i++)
		{
			pw.println(s1.pop());
		}

		
	}

}
