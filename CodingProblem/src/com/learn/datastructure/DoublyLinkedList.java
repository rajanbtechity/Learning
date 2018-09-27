package com.learn.datastructure;

class DLLNode {
	DLLNode next;
	DLLNode prev;
	int key;

	DLLNode(int key) {
		this.key = key;
	}
}

public class DoublyLinkedList {

	DLLNode head;

	void addNode(int data) {
		DLLNode newNode=new DLLNode(data);
		System.out.println("Added "+newNode.key);
		if(head==null)
		{
			head=newNode;
			head.next=null;
			head.prev=null;
			return;	
		}

		DLLNode currNode=head;
		while(currNode.next!=null)
		{
			currNode=currNode.next;
		}
		currNode.next=newNode;
		newNode.prev=currNode;
		newNode.next=null;
		

	}

	DLLNode deleteNode() {
		DLLNode tmp = null;
		return tmp;
	}
	
	void printNode()
	{
		DLLNode currNode=head;
		
		while(currNode!=null)
		{
			System.out.print(currNode.key+" ");
			if(currNode.prev!=null)
			{
				System.out.print(" prev:"+currNode.prev.key);
			}
			if(currNode.next!=null)
			{
				System.out.print(" next:"+currNode.next.key);
			}
			System.out.println();
			currNode=currNode.next;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList l1=new DoublyLinkedList();
		int ary[]={1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("Adding Nodes");
		for(int i=0;i<ary.length;i++)
		{
			l1.addNode(ary[i]);
		}
		
		System.out.println("Printing Nodes");
		l1.printNode();

	}

}
