package backtrace.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2023/5/9 9:35
 */
public class 牛牛走台阶 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ls = br.readLine().split(" ");
        int n = Integer.parseInt(ls[0]);
        int m = Integer.parseInt(ls[1]);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        System.out.println(dp(n, m));

        System.out.println(memSearch(0, 0, 0, n, m));

        backtrace(0, 0, 0, n, m);
        System.out.println(res);

        br.close();
    }

    final static int MOD = 1000000007;

    public static int dp(int n, int m){
        int[][][] dp = new int[n+1][m+1][m+1];
        // 初始值
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    for (int l = 0; l <= m; l++) {
                        if (i < j || (j == k && k != 0) || (k == l && k != 0) || (j == l && l != 0)) {
                            continue;
                        }
                        dp[i][j][k] += dp[i - j][k][l];
                        dp[i][j][k] %= MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                ans += dp[n][i][j];
                ans %= MOD;
            }
        }
        return ans;
    }


    // 记忆化搜索
    static int[][][] memo = new int[100010][8][8];
    // 参数： 已走步数，上一步，上上步
    public static int memSearch(int sum, int lt, int bflt, int n, int m){
        // 出口
        if(sum >= n){
            if (sum == n) return 1;
            return 0;
        }

        if (memo[sum][lt][bflt] != -1) return memo[sum][lt][bflt];

        int ans = 0;
        for(int i = 1; i <= m; ++i){
            if (i != lt && i != bflt){
                ans += memSearch(sum + i, i, lt, n, m);
                ans = ans%1000000007;
            }
        }

        memo[sum][lt][bflt] = ans;
        return ans;
    }



    // 回溯写法
    static int res = 0;
    // 参数： 已走步数，上一步，上上步
    public static void backtrace(int sum, int lt, int bflt, int n, int m){
        // 出口
        if(sum >= n){
            if (sum == n) res++;
            return;
        }

        for (int i = 1; i <= m; i++) {
            if (i != lt && i != bflt){
                backtrace(sum + i, i, lt, n, m);
            }
        }
    }
}
