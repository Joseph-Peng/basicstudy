package offer2;

import java.util.Deque;
import java.util.LinkedList;

public class Offer2_038每日温度 {

    // 判别是否需要使用单调栈，如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈
    // [73, 74, 75, 71, 69, 72, 76, 73]
    //  73               0
    //  74               1
    //  75               2
    //  75 71            2 3
    //  75 71 69         2 3 4
    //  75 72            2 5
    //  76               6
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) return new int[1];
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; ++i){
            int t = temperatures[i];
            while (!stack.isEmpty() && t > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
