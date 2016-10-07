package com.ankit.stack;

import java.awt.List;
import java.util.Stack;

public class Mystack {
	
	public Stack<Integer> stack;
	
	public void poulateSatck(){
		stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
	}
	
	public void insertAtBottom(int temp){
		if (stack.isEmpty()) {
			stack.push(temp);
			return;
		}
		else {
			int popped=stack.pop();
		insertAtBottom(temp);
		stack.push(popped);
		}
	}
	
	public void reverseStackUsingRec(){
		if(stack.isEmpty()) return;
		Integer temp=stack.pop();
		reverseStackUsingRec();
		insertAtBottom(temp);
	}
	
	public static void nextGreaterElement(int[] a){
		
		Stack<Integer> stack=new Stack<Integer>();
		
		stack.push(a[0]);
		int curr=1;
		while(curr<a.length){
			int temp=a[curr];
			while(!stack.isEmpty() && temp>stack.peek())
			{
			Integer i=stack.pop();
			System.out.println(i+" -->"+temp);
			
			}
		
			stack.push(temp);
			curr++;
			
		}
		
		while(!stack.isEmpty()){
			int pop=stack.pop();
			System.out.println(pop+"-->"+"-1");
			
		}
		//System.out.println(stack.toString());
		
		
	}
	
	public static void main(String[] args) {
		//int[] a={40,50,11,32,55,68,75};
		//int[] a={9,8,7,6,5};
		

	Mystack m = new Mystack();
	m.poulateSatck();
	System.out.println(m.stack);
	m.reverseStackUsingRec();
	System.out.println(m.stack);
		
		//Mystack.nextGreaterElement(a);
	}

}

//refer: http://stackoverflow.com/questions/19720349/find-next-higher-element-in-an-array-for-each-element

/*
 * 50,11,32,55,68,75                        40 
 *    11,32,55,68,75              40->50    50    
 *       ,32,55,68,75                       50,11
 *       55,68,75                   11->32  50,32
 *          68,75                  32->55   50    temp=55 again in while loop
 *                                 50->55   55     loop exits
 *          75                     55->68   68 
 *                                 68->75   75
 *                                  75->-1  empty    next while loop                      
 *                                 
 * 
 * 
 * 
 * 
 * 
 */

