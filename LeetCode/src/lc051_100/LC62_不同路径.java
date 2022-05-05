package lc051_100;

import java.util.Arrays;

public class LC62_不同路径 {

    public int uniquePaths(int m, int n) {
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
}
