package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer30_包含min函数的栈 {
}

class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
