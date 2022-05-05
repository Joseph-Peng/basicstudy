package lc201to300;

import java.util.Arrays;

public class LC213_打家劫舍II {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] memo1 = new int[nums.length];
        Arrays.fill(memo1, -1);
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo2, -1);

        int ans1 = dfs(0,nums.length-2, nums, memo1);
        int ans2 = dfs(1,nums.length-1, nums, memo2);
        return Math.max(ans1,ans2);
    }

    // 参数： idx、len(表示能访问的数组长度)
    public int dfs(int idx, int len,int[] nums, int[] memory){
        if (idx >= len){
            if (idx == len) return nums[idx];
            return 0;
        }

        if (memory[idx] != -1){
            return memory[idx];
        }

        int ans = 0;
        ans = Math.max(dfs(idx+1, len,nums,memory), dfs(idx+2,len,nums,memory) + nums[idx]);
        memory[idx] = ans;
        return ans;
    }
}
