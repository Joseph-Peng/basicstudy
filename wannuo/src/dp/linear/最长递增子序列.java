package dp.linear;

import java.util.Arrays;

public class 最长递增子序列 {

    public static void main(String[] args) {
        int[] nums = {1,3,2,4,5};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j<i; ++j){
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[nums.length - 1]);
        System.out.println(Arrays.toString(dp));
    }
}
