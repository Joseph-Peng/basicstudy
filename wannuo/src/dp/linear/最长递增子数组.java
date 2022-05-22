package dp.linear;

import java.util.Arrays;

public class 最长递增子数组 {

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5};
        int maxLen = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; ++i){
            if (nums[i] > nums[i-1]) dp[i] = dp[i-1] + 1;
            maxLen = Math.max(dp[i], maxLen);
        }
        System.out.println(maxLen);
    }
}
