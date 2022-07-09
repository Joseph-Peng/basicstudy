package graph;

import java.util.Arrays;

public class Flory {

    /**
     *
     * @param n
     * @return 节点之间的最小权值
     */
    public int[][] flory(int n, int[][] G){
        int[][] dp = new int[n+1][n+1];
        // 初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 100010);
        }
        for(int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = G[i][j];
            }
        }
        /*for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }*/

        for(int k = 1; k <= n; ++k){
            for(int i = 1; i <= n; ++i){
                for(int j = 1; j <= n; ++j){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp;
    }
}
