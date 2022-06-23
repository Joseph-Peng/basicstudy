package offer2;

import java.util.Arrays;

public class Offer2_091粉刷房子 {


    // dp
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i<n; ++i){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        return Math.min(dp[n-1][0] ,Math.min(dp[n-1][1], dp[n-1][2]));
    }

    // 记搜
    public int minCost2(int[][] costs) {
        memory = new int[costs.length][3];
        return dfs(0,-1,costs);
    }

    int[][] memory;

    // idx
    public int dfs(int idx, int pre,int[][] costs){
        if (idx == costs.length){
            return 0;
        }

        if (pre != -1 && memory[idx][pre] != 0) return memory[idx][pre];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 3; ++i){
            if (pre!=i) ans = Math.min(costs[idx][i] + dfs(idx+1, i, costs), ans);
        }
        if (pre == -1) return ans;
        memory[idx][pre] = ans;
        return ans;
    }
}
