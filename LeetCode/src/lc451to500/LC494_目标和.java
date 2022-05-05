package lc451to500;

import java.util.HashMap;
import java.util.Map;

public class LC494_目标和 {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0,0,nums, target);
    }

    Map<String,Integer> memory = new HashMap<>();
    public int dfs(int idx, int sum, int[] nums, int target){
        if (idx >= nums.length){
            if (idx == nums.length && sum == target) return 1;
            return 0;
        }
        String key = idx +":"+sum;
        if (memory.containsKey(key)) return memory.get(key);
        int ans = 0;
        ans += dfs(idx+1, sum+nums[idx], nums, target) + dfs(idx+1, sum-nums[idx],nums,target);
        memory.put(key,ans);
        return ans;
    }
}
