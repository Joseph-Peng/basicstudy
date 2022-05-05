package lc051_100;

import java.util.Arrays;

public class LC64_最小路径和 {

    public int minPathSum(int[][] grid) {
        memory = new int[grid.length][grid[0].length];
        for(int i = 0; i<grid.length;++i){
            Arrays.fill(memory[i],-1);
        }
        return dfs(0,0,grid);
    }

    int[][] memory;

    public int dfs(int i, int j, int[][] grid){
        if (i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }

        if (i>=grid.length || j>=grid[0].length){
            return 1000;
        }

        if (memory[i][j] != -1) return memory[i][j];

        int ans = 0;
        ans = Math.min(dfs(i+1,j,grid), dfs(i,j+1,grid)) + grid[i][j];
        memory[i][j] = ans;
        return ans;
    }
}
