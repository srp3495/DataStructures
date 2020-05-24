package com.srp.learn;

import org.omg.IOP.Codec;
import org.omg.IOP.CodecOperations;

public class LinkedList<X> {
	private Node first;
	private Node last;
	private int nodeCount;

	public LinkedList() {
		first=null;
		last=null;
		nodeCount=0;
	}
	
	public int size() {
		return nodeCount;
	}
	
	public void add(X item) {
		
		if(first==null) //checking if there is any node
		{
			first =new Node(item);
			last=first;
		
		
	}
		
		
		else {
			Node newNode=new Node(item);
			last.setNextNode(newNode);
			last=newNode;
		}
		
		nodeCount++;
	}
	
	
	
	
	public void insert(X item,int position) {
		
		if(size()<position) {
			throw new IllegalStateException("This position is not available");
		}
		Node currentNode=first;
		for(int i=1;i<position&&currentNode!=null;i++) {
			currentNode=currentNode.nextNode;
		}
		
		
		Node newnode=new Node(item);
		Node nextNode=currentNode.nextNode;
		currentNode.setNextNode(newnode);
		newnode.setNextNode(nextNode);
		
		nodeCount++;
	}
	
	
	public X removeAt(int position) {
		
		if(size()<position) {
			throw new IllegalStateException("no such node");
			
		}
		
		Node currentNode=first;
		Node prevNode=first;
		for(int i=0;i<position&&currentNode!=null;i++)
		{
			prevNode=currentNode;
			currentNode=currentNode.nextNode;
		}
		
		X item=currentNode.getItem();
		Node nextnode=currentNode.nextNode;
		prevNode.setNextNode(nextnode);
		nodeCount--;
		return item;
		
		
		
	}
	
	
	
	public X remove() //will simply pull first node
	{
		X rItem;
		if(first==null) {
			throw new IllegalStateException("Linked list is empty");
		}
		else {
			rItem= first.getItem();
			first=first.nextNode;
			nodeCount--;
			
		}
		return rItem;
	}
	
	
	
	public X get(int position) {
		
		if(first==null) {
			throw new IllegalStateException("Not such position");
			
		}
		
		Node currentNode=first;
		for(int i=0;i<size()&&currentNode!=null;i++) {
			
			if(i==position) {return currentNode.getItem();}
			currentNode=currentNode.nextNode;
		}
		
		return null;
		
	}
	
	
	
	public int find(X item) {
		if(first==null) {
			throw new IllegalStateException("list is empty");
		}
		
		Node currentNode=first;
		for(int i=1;i<size()&&currentNode!=null;i++) {
			if(currentNode.getItem().equals(item)) {return i;}
			
			currentNode=currentNode.getNextNode();
		}
		return -1;
	}
	
	
	
	public String toString() {
		StringBuffer contents=new StringBuffer();
		Node curNode=first;
		
		while(curNode!=null) {
			contents=contents.append(curNode.getItem());
			curNode=curNode.nextNode;
			
			if(curNode!=null) {
				contents.append(", ");
			}
		}
		
		return contents.toString();
	}
	
	
	
	private class Node{
		private X item;
		private Node nextNode;
	
	public Node(X item) {
		this.item=item;
		this.nextNode=null;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public X getItem() {
		return item;
	}
	
	}
}
