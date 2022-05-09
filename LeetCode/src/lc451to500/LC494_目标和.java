package lc451to500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC494_目标和 {

    /*
    记搜
     */
    public int findTargetSumWays1(int[] nums, int target) {
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

    /*
    dp
    式子：f(i,j) = f(i-1,j) + f(i-1, j-nums[i])
    base case： f(0,0) = 1
    规模： i->数组长度 ； j -> neg
    遍历方向：一行一行遍历
     */
    public int findTargetSumWays2(int[] nums, int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int neg = sum - target;
        if ((neg)%2 != 0 || sum<target) return 0;
        neg /= 2;
        // 就变成在数组中找出和为neg的子集的个数
        int[][] dp = new int[nums.length + 1][neg + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; ++i){
            for(int j = neg; j>=0; --j){
                if (j >= nums[i-1])
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][neg];
    }

    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int neg = sum - target;
        if ((neg)%2 != 0 || sum<target) return 0;
        neg /= 2;
        // 就变成在数组中找出和为neg的子集的个数
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for(int i = 1; i <= nums.length; ++i){
            for(int j = neg; j >= nums[i-1]; --j){
                    dp[j] = dp[j] + dp[j-nums[i-1]];
            }
        }
        return dp[neg];
    }
}
