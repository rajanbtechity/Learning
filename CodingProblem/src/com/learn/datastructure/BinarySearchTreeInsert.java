package com.learn.datastructure;

class BSTNode
{
	BSTNode left,right;
	int data;
	
	BSTNode(int data)
	{
		this.data=data;
	}
}

public class BinarySearchTreeInsert {
	public static BSTNode root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeInsert t1=new BinarySearchTreeInsert();
		int ary[]={2,1,3};
		for(int i=0;i<ary.length;i++)
		{
			BSTNode newNode=new BSTNode(ary[i]);
			t1.insertBST(root,newNode,ary[i]);
			
			//root=t1.insertRec(root, ary[i]);
		}
		t1.preOrder(root);

	}
	
	
	BSTNode insertRec(BSTNode root, int key) {
		 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
	
	public void insertBST(BSTNode currNode,BSTNode newNode,int data)
	{
		
		if(root==null)
		{
			root=newNode;
			return;
		}
		
		
		if(currNode.data<=data)
		{
			if(currNode.right!=null)
			{
			insertBST(currNode.right,newNode,data);
			}
			else
			{
				currNode.right=newNode;
				return;
			}
		}
		else
		{
			if(currNode.left!=null)
			{
			insertBST(currNode.left,newNode,data);
			}
			else
			{
				currNode.left=newNode;
			}
		}
		return;
		
	}
	
	public void inorderBST(BSTNode root)
	{
		
	}
	
	public void preOrder(BSTNode currNode)
	{
		if(currNode!=null)
		{
			System.out.println(currNode.data);
			preOrder(currNode.left);
			preOrder(currNode.right);
		}
			
		
	}

}
