package com.learn.datastructure;

import java.util.Arrays;

class TreeNode
{
	TreeNode left;
	TreeNode right;
	int data;
	
	TreeNode(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class BinarySearchTree {
	
	static TreeNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ary[]={4,2,5,8,1,10,9,3,7,6};
		Arrays.sort(ary);
		BinarySearchTree t1=new BinarySearchTree();
		root=t1.createBST(ary,0,ary.length-1);
		t1.preOrder(root);
		//System.out.println(root);

	}

	private TreeNode createBST(int[] ary,int start,int end) {
		// TODO Auto-generated method stub
		//System.out.println("createBST invoked with start:"+start+" and end:"+end);
		if(start>end)
		{
			return null;
		}
		int mid=(start+end)/2;
		TreeNode node=new TreeNode(ary[mid]);
		node.left=createBST(ary,start,mid-1);
		node.right=createBST(ary,mid+1,end);
		
		return node;
		
	}
	
	public void preOrder(TreeNode currNode)
	{
		if(currNode!=null)
		{
			System.out.println(currNode.data);
			preOrder(currNode.left);
			preOrder(currNode.right);
		}
			
		
	}

}
