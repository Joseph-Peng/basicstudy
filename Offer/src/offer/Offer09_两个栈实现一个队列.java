package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer09_两个栈实现一个队列 {
}

class CQueue{

    public Deque<Integer> stack1;
    public Deque<Integer> stack2;

    public CQueue(){
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty()? -1 : stack2.pop();
    }

}