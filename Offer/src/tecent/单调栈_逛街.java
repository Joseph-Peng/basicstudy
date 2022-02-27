package tecent;

import java.util.Arrays;
import java.util.Stack;

public class 单调栈_逛街 {

    public int[] findBuilding (int[] heights) {
        Stack<Integer> stackL = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        // 最起码能看见自己的楼
        Arrays.fill(res,1);
        for(int i = 0; i<n-1;++i){ //首先向左看
            // 只要当前楼的高度大于前面遍历过的楼的高度，那么就直接把前面的楼丢掉
            // 因为当前楼挡住了前面的楼
            while (!stackL.isEmpty() && heights[i]>=stackL.peek()){
                stackL.pop();
            }
            stackL.push(heights[i]);
            //这里i+1才是核心，因为我已经通过while循环把比当前楼矮的都去掉了，所以栈里剩下的都比当前楼高
            //也就是说当我站在该楼的右边一栋楼，栈里的楼我都能看到
            res[i+1] += stackL.size();
        }
        Stack<Integer> stackR = new Stack<>();
        for(int i = n-1; i>0; --i){ // 往右看
            while (!stackR.isEmpty() && heights[i]>=stackR.peek()){
                stackR.pop();
            }
            stackR.push(heights[i]);
            res[i-1] += stackR.size();
        }
        return res;
    }
}
