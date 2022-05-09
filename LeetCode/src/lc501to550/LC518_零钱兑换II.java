package lc501to550;

import java.util.Arrays;

public class LC518_零钱兑换II {

    public int change1(int amount, int[] coins) {
        memory = new int[coins.length][amount+1];
        for (int i = 0; i<coins.length; ++i){
            Arrays.fill(memory[i], -1);
        }
        return dfs(0,amount,coins);
    }

    int memory[][];
    public int dfs(int idx, int amount, int[] coins){
        if (amount <= 0){
            if (amount == 0) return 1;
            return 0;
        }
        if (memory[idx][amount] != -1) return memory[idx][amount];
        int ans = 0;
        for(int i = idx; i<coins.length; ++i){
            ans += dfs(i,amount-coins[i], coins);
        }

        memory[idx][amount] = ans;
        return ans;
    }

    /*
    dp
    式子：f(i,j) = f(i-1, j) + f(i, j-coins[i]);
    base case:dp[0][0] = 1;
    规模：
    填表顺序：
     */
    public static int change2(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1; i<=coins.length; ++i){
            for (int j = 0; j <= amount; ++j){
                // 完全背包，i而不是i-1，表示等一下还可以考虑这个物品选或不选
                if (j>=coins[i-1]) dp[i][j] += dp[i-1][j] + dp[i][j-coins[i-1]];
                else dp[i][j] += dp[i-1][j];
            }
        }
        /*for(int[] dpi : dp){
            System.out.println(Arrays.toString(dpi));
        }*/
        return dp[coins.length][amount];
    }

    public static int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0] = 1;
        for(int i = 1; i<=coins.length; ++i){
            for (int j = coins[i-1]; j <= amount; ++j){
                // 完全背包，i而不是i-1，表示等一下还可以考虑这个物品选或不选
                dp[j] += dp[j-coins[i-1]];
            }
        }
        // System.out.println(dp[amount]);
        return dp[amount];
    }

    public static void main(String[] args) {
        change(5,new int[]{1,2,5});
    }

}
