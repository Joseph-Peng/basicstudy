package offer;

import java.util.HashSet;
import java.util.Set;

public class Offer61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums){
        // 统计最大值、统计最小值
        int max = -1, min = 14;

        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(num == 0) {
                continue;
            }
            if (set.contains(num)) return false;
            set.add(num);
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        return max-min<=4;
    }
}
