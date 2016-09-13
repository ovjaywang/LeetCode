package com.wjy.code;
import java.util.Stack;
/**
 * 仅仅使用stack完成queue的FIFO操作
 * @author Jay Wang
 *
 */
public class Implement_Queue_Using_Stack {
		Stack<Integer> stack = new Stack<Integer>();
		int size = 0;
	 	public void push(int x) {
	        int [] tmp =  new int[size];
	        Stack<Integer> t = new Stack<Integer>();
	        t.addAll(stack);
	        stack.removeAllElements();
	        stack.add(x);
	        stack.addAll(t);
	        size++;
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        stack.pop();
	        size--;
	    }

	    // Get the front element.
	    public int peek() {
	        return stack.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return stack.isEmpty();
	    
}
	    }
