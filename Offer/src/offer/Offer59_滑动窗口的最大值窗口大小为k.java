package offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Offer59_滑动窗口的最大值窗口大小为k {

    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue.peekLast());

    }

    // 使用双端队列
    public static int[] maxSlidingWindow(int[] nums, int k){
        //单调队列
        //下面是要注意的点：
        //队列按从大到小放入
        //如果首位值（即最大值）不在窗口区间，删除首位
        //如果新增的值小于队列尾部值，加到队列尾部
        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if (nums==null || nums.length==0 || k==0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int res[] = new int[nums.length-k+1];
        int i = 0;
        for (;i<k;++i){
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            while (!queue.isEmpty() && nums[i]>queue.peekLast()){
                queue.removeLast();
            }
            queue.offer(nums[i]);
        }
        res[0] = queue.peek();
        for (;i<nums.length;++i){
            if (nums[i-k] == queue.peekFirst()){
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i]>queue.peekLast()){
                queue.removeLast();
            }
            queue.offer(nums[i]);
            res[i-k+1] = queue.peekFirst();
        }
        return res;
    }
}
