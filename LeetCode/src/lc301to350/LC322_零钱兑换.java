package lc301to350;

import java.util.Arrays;
import java.util.Map;

public class LC322_零钱兑换 {

    // 给定一个整数数组coins 以及
    // 一个amount表示总金额数

    /*
    式子：f(i,j) = Math.min(f(i-1, j), f(i, j-coins[i]) + 1)
    base case: 第一行   dp[0][0] = 0; 其他的 dp[0][j] = 10001;
    规模: i->coins.length   j->amount
    遍历顺序 : i->coins.length   j->amount
     */
    public int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp[0], amount+1);
        dp[0][0] = 0;
        for(int i = 1; i <= coins.length; ++i){
            for(int j = 0; j <= amount; ++j){
                if(j >= coins[i-1])
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][amount] == (amount+1) ? -1 : dp[coins.length][amount];
    }
    /*
    压缩
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i <= coins.length; ++i){
            for(int j = coins[i-1]; j <= amount; ++j){
                    dp[j] = Math.min(dp[j], dp[j-coins[i-1]] + 1);
            }
        }
        return dp[amount] == (amount+1) ? -1 : dp[amount];
    }

    // 解法1，自顶向下的，带备忘录的递归解法
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        // 使用备忘录，所以要创建一个存放记录的数组，长度为amount
        return dp(coins, amount, new int[amount]);
    }

    private int dp(int[] coins, int amount, int[] memo) {
        // 边界条件
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //查备忘录，避免重复计算
        if (memo[amount - 1] != 0) return memo[amount-1];

        // 开始计算，通过子问题中的最优解，求得当前的最优解
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin, memo);
            // 如果这个子问题有解，才更新状态，否则就不处理
            if (subProblem>=0){
                res = Math.min(res, subProblem + 1);
            }
        }
        memo[amount-1] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount-1];
    }



}
