package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer31_栈的压入和弹出序列 {

    public boolean validateStackSequences(int[] pushed, int[] popped){
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i<pushed.length){
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && popped[j] == stack.peek()){
                stack.pop();
                ++j;
            }
        }
        return j==popped.length;
    }
}
