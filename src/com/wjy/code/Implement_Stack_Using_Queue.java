package com.wjy.code;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_Using_Queue {
	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> qu;
    public void push(int x) {
    	qu = new LinkedList<Integer>();
    	qu.addAll(q);
    	q.clear();
    	q.add(x);
    	q.addAll(qu);
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
