package graph;

import java.util.Arrays;

public class LC1334_阈值距离内邻居最少的城市 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = flory(n, edges);
        int ans = -1;
        int minCount = 1000000;
        for (int i = 0 ; i < n ; i++) {
            int cnt = 0;
            for (int j = 0 ; j < n ; j++) {
                if (i != j && distances[i][j] <= distanceThreshold) cnt++;
            }
            if (cnt <= minCount){
                ans = i;
                minCount = cnt;
            }
        }
        return ans;
    }



    /**
     *
     * @param n
     * @return 节点之间的最小权值
     */
    public int[][] flory(int n, int[][] edges){
        int[][] dp = new int[n][n];
        // 初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 100010);
        }
        for(int[] edge : edges){
            int a = edge[0], b = edge[1], w = edge[2];
            dp[a][b] = w;
            dp[b][a] = w;
        }
        for (int i = 0 ; i < n ; i++) dp[i][i] = 0;

        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp;
    }

}
