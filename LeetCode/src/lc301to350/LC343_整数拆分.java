package lc301to350;

import java.util.Arrays;

public class LC343_整数拆分 {

    public int integerBreak(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dfs(n);
    }

    int[] memo;

    private int dfs(int n) {
        if (n == 2) return 1;
        if (memo[n] != -1) return memo[n];
        int ans = 0;
        // 至少拆为两份， 所以这里i<n
        for (int i =1; i < n; ++i){
            ans = Math.max(ans, Math.max(dfs(n-i) * i, i*(n-i)));
        }
        memo[n] = ans;
        return ans;
    }


}
