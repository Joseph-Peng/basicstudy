package lc151to200;

import java.util.Arrays;

public class LC198_打家劫舍 {

    public int rob(int[] nums) {
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
}
