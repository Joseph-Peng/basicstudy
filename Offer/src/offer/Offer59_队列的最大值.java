package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer59_队列的最大值 {

    class MaxQueue {

        //一个队列存放值
        private Deque<Integer> queue;
        //一个单调队列存放最大值
        private Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.isEmpty()?-1:maxQueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && value>maxQueue.peekLast()){
                maxQueue.removeLast();
            }
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            int value = queue.poll();
            if (value == maxQueue.peekFirst()){
                maxQueue.removeFirst();
            }
            return value;
        }
    }
}
