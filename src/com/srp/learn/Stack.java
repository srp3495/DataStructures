package com.srp.learn;

public class Stack<X> {
 
	
	 private X[] data;
	 public int stackpointer;
	 
	 public Stack() {
		 data=(X[]) new Object[1000];
		 stackpointer=0;
		 
	 }
	 
	public void push(X item) {
		
		if(stackpointer>999) {
			throw new IllegalArgumentException("Max size reached");
		}
		else
		data[stackpointer++]=item;
	}
	
	
	public X pop() {
		
		if(stackpointer==0) {
			throw new IllegalArgumentException("No more data to pop");
		}
		return data[--stackpointer];
		
	}
	
	
	public boolean contains(X item) {
		for(int i=0;i<stackpointer;i++) {
			if (data[i]==item) {return true;}
			
		}
		
			return false;
	}
	
	public X access(X item) {
		
		while(stackpointer>0) {
		X popped=pop();
		
		if(popped.equals(item)) {return popped;}
		}
		throw new IllegalArgumentException("Could not found");
		
	}
	
	public int size() {
		return stackpointer;
	}
	
}
