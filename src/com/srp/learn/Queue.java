package com.srp.learn;

public class Queue<X> {
 private int front;
 private int end;
	
	private X[] data;
	public Queue() {
		this(1000);
	}
	
	public Queue(int size) {
		this.front=-1;
		this.end=-1;
		data=(X[])new Object[size];
	}
	
	
	public int size() {
		if(front==-1&&end==-1) {return 0;}
		else return end-front+1;
	}
	
	
	
	public void enQueue(X item) {
		if(((end+1)%(data.length))==front) {
			throw new IllegalStateException("Queue is full");
		}
		else if (size()==0) {
			end++;
			front++;
			data[end]=item;
			
		}
			
		else 
		{end++;
		data[end]=item;
		}
		
	}
	
	
	public X deQueue() {
		X item=null;
		if(size()==0) {
			throw new IllegalStateException("Queue is empty");
		}
		
		else if(front==end) {
			item=data[front];
			front=-1;
			end=-1;
		}
		
		else {
	    item=data[front];
		front++;
		
		}
		
		return item;
	}
	
	public boolean contains(X item) {
		
		if(size()==0) {
			return false;
		}
		
		for(int i=front;i<end;i++) {
			if(data[i]==item) {return true;}
			
		}
		 return false;
		
	}
	
	public X access(int position) {
		X item =null;
		if(size()==0||position>size()) {
			throw new IllegalStateException("Not found");
		}
		int trueIndex=0;
		
		for(int i=front;i<end;i++) {
			if(trueIndex==position) {
				item=data[i];
				return item;
			}
			trueIndex++;
		}
		throw new IllegalStateException("Could not get item");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
