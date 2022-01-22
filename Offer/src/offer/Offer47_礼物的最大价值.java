package offer;

public class Offer47_礼物的最大价值 {

    /*
    动态规划
                 dp[i][j-1] + grid[i][j]                    i==0;
    dp[i][j] =   dp[i-1][j] + grid[i][j]                    j==0;
                 Max(dp[i-1][j],dp[i][j-1]) + grid[i][j]    0<i<len,0<j<len
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(i==0 && j>0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else if(j==0 && i>0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else if(i>0 && j>0){
                    grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
