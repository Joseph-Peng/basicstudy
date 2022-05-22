package lc201to300;

import java.util.Arrays;

public class LC213_打家劫舍II {

    public int rob1(int[] nums) {
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

    /*
    dp
     */
    public int rob(int[] nums) {
        // 只有一个元素，就返回该元素的值
        if(nums.length == 1){
            return nums[0];
        }
        // 两个元素，就返回两元素中其中一个最大值
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 偷第一家
        int first = nums[0], second = nums[0];
        for(int i = 2; i<nums.length-1;++i){
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        int profit1 = second;
        // 不偷第一家
        first = 0;
        second = nums[1];
        for(int i = 2; i<nums.length; ++i){
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        return Math.max(second,profit1);
    }
}
