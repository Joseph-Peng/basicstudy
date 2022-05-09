package lc301to350;

import java.util.Arrays;

public class LC343_整数拆分 {

    public int integerBreak1(int n) {
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

    /*
    dp
    式子：f(n) = max(f(n-i) * i, i * (n-i))
    base case:
    规模： n
    填表顺序：1-->n
     */
    public int integerBreak(int n) {
        if ( n < 2) return 0;
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i<=n; ++i){
            for(int j = 1; j < i; ++j){
                dp[i] = Math.max(dp[i-j] * j, j*(i-j));
            }
        }
        return dp[n];
    }

}
