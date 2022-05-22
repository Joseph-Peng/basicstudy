package lc151to200;

import java.util.Arrays;

public class LC198_打家劫舍 {

    public int rob1(int[] nums) {
        memory = new int[nums.length];
        Arrays.fill(memory,-1);
        return dfs(0, nums);
    }

    int memory[];

    // 参数： idx
    public int dfs(int idx,int[] nums){
        // 出口
        if (idx >= nums.length-1){
            if(idx == nums.length-1) return nums[idx];
            return 0;
        }
        if (memory[idx] != -1) return memory[idx];
        int ans = 0;
        ans = Math.max(dfs(idx+1,nums),dfs(idx+2,nums) + nums[idx]);
        memory[idx] = ans;
        return ans;
    }

    /*
    dp
     */
    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i<nums.length; ++i){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }

    /*
    dp
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0],nums[1]);
        for(int i = 2; i<nums.length; ++i){
            int t = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = t;
        }
        return dp1;
    }
}
