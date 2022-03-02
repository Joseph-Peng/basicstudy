package offer2;

import java.util.HashMap;
import java.util.Map;

public class Offer2_010和为k的连续子数组 {

    /**
     * 注意有负数不能使用滑动窗口，所以使用前缀和的方法
     */
    public int subarraySum(int[] nums, int k) {
        // map中保存(前缀和，出现次数)
        Map<Integer,Integer> dict = new HashMap<>();
        /*需要考虑如果以数组nums[0]为开头的连续子数组就满足题意呢？
		此时候我们的哈希表还是空的，没办法计算前缀和！所以遇到这类题目，都需要在哈希表中默认插入一个{0:1}的键值对，
		用于解决从数组开头的连续子数组满足题意的特殊场景。*/
        dict.put(0,1);
        int res = 0;
        int pre = 0;
        for(int i = 0; i<nums.length; ++i){
            pre += nums[i];
            res += dict.getOrDefault(pre-k,0);
            dict.put(pre, dict.getOrDefault(pre, 0)+1);
        }
        return res;
    }
}
