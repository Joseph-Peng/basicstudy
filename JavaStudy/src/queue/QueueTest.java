package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Joseph Peng
 * @date 2022/9/1 9:12
 */
public class QueueTest {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.println(deque);
        System.out.println("deque.peek() : " + deque.peek());
        System.out.println("deque.peekLast() : " + deque.peekLast());
        System.out.println("deque.peekFirst() : " + deque.peekFirst());
        System.out.println("Deque:左边是栈顶，右边是栈底！");

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
