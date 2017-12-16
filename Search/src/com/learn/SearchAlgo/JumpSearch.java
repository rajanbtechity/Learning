package com.learn.SearchAlgo;

public class JumpSearch {

	public static int JumpSearch(int[] ary,int x)
	{
        int r=ary.length;
		int m=(int)Math.sqrt(r);
		int index=m-1;
		
		while(m<=r)
		{
          if(ary[index]==x)
            return index;
          else if(x>ary[index])
            index=index+m;
            else if(x<ary[index])
            break;
		
		}
      
      for(int i=index-m+1;i<index-1;i++)
      {
        if(ary[i]==x)
          return i;
      }
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={1,2,3,4,5,6,7,8,9};
		int index=JumpSearch(array,4);
		if(index==-1)
          System.out.println("Element not found");
      else 
        System.out.println("Index found at index : "+index);
        

	}

}
