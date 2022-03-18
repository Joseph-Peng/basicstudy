package nowcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0 || size>num.length) return res;
        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        for(;i<size;++i){
            while(!queue.isEmpty() && queue.peekLast()<num[i]){
                queue.removeLast();
            }
            queue.offer(num[i]);
        }
        res.add(queue.peek());

        for(; i<num.length;++i){
            if(num[i-size] == queue.peekFirst()){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast()<num[i]){
                queue.removeLast();
            }
            queue.offer(num[i]);
            res.add(queue.peekFirst());
        }
        return res;
    }
}
