package lc051_100;

import java.util.Arrays;

public class LC63_不同路径II {

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, obstacleGrid);
    }

    int[][] memo;

    public int dfs(int i, int j, int[][] obstacleGrid) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int ans = 0;
        ans = dfs(i + 1, j, obstacleGrid) + dfs(i, j + 1, obstacleGrid);
        memo[i][j] = ans;
        return ans;
    }

    /*
    dp
    式子： if(obstacleGrid[i,j] == 1) f(i,j) = 0
          else f(i,j) = f(i-1,j) + f(i,j-1)
    base case：i = 0  f(i,j) = 1,遇到obstacleGrid[i,j] == 1，后面全部置为0，j=0也一样
    规模：矩阵大小
    填表顺序：一行一行填
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; ++i) {
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


}
