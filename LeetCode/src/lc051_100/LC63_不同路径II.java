package lc051_100;

import java.util.Arrays;

public class LC63_不同路径II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int i = 0; i<m; ++i){
            Arrays.fill(memo[i], -1);
        }

        return dfs(0,0,obstacleGrid);
    }

    int[][] memo;
    public int dfs(int i, int j, int[][] obstacleGrid){
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) return 0;
        if (i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1) {
            return 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        int ans = 0;
        ans = dfs(i+1, j, obstacleGrid) + dfs(i, j+1, obstacleGrid);
        memo[i][j] = ans;
        return ans;
    }
}
