package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Offer49_丑数 {

    public int nthUglyNumber(int n){
        // 三个指针记录当前的数是否乘过2,3,5
        int p2 = 0, p3 = 0, p5 = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1; i<n; ++i){
            int t2 = dp[p2] * 2;
            int t3 = dp[p3] * 3;
            int t5 = dp[p5] * 5;

            dp[i] = Math.min(Math.min(t2,t3),t5);
            // 这里用if不用else if 是为了让出现相同的t2、t3、t5时都进位
            if(dp[i] == t2) ++p2;
            if(dp[i] == t3) ++p3;
            if(dp[i] == t5) ++p5;
        }
        return dp[n-1];
    }

    public int nthUglyNumber2(int n){
        int[] factors = {2,3,5};
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<>();
        minHeap.offer(1L);
        set.add(1L);
        int uglyNum = 0;
        for(int i = 0; i<n; ++i){
            long current = minHeap.poll();
            uglyNum = (int) current;
            for (int factor : factors){
                long next = current*factor;
                if(set.add(next)){
                    minHeap.offer(next);
                }
            }
        }
        return uglyNum;
    }
}
