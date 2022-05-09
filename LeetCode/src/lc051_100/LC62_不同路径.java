package lc051_100;

import java.util.Arrays;

public class LC62_不同路径 {

    public int uniquePaths1(int m, int n) {
        memory = new int[m+1][n+1];
        for (int i = 0; i<=m; ++i){
            Arrays.fill(memory[i], -1);
        }

        return dfs(1,1,m,n);
    }

    int[][] memory;

    public int dfs(int i, int j, int m, int n){
        if (i==m && j==n) return 1;
        if (i>m || j>n) return 0;
        if (memory[i][j] != -1) return memory[i][j];
        int ans = 0;
        ans = dfs(i+1, j, m, n) + dfs(i, j+1, m , n);
        memory[i][j] = ans;
        return ans;
    }

    /*
    dp
    式子：f(i,j) = f(i-1,j) + f(i,j-1)
    base case：f(0,j) = 1; f(i,0) = 1;
    规模：i->m; j->n;
    填表顺序：一行一行填
     */
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i<m; ++i){
            for(int j = 1; j < n; ++j){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
