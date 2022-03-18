package nowcoder;

public class 股票的最大利润2 {

    // 也可以使用动态规划
    // dp[i][0]表示第i天交易完成后手里没有股票的最大利润，
    // dp[i][1]表示第i天交易完成后手里有股票的最大利润
    // 状态转移：
    // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    // dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])
    // 初始状态 dp[0][0] = 0   dp[0][1] = -prices[0]
    // 由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，
    // 因此这时候 dp[n-1][0] 的收益必然是大于dp[n-1][1] 的，
    // 最后的答案即为dp[n-1][0]。
    public int maxProfit (int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for(int i = 1; i<n;++i){
            dp0 = Math.max(dp0, dp1+prices[i]);
            dp1 = Math.max(dp0-prices[i], dp1);
        }
        return dp0;
    }

    // 可以使用贪心算法
    public int maxProfit1 (int[] prices) {
        int sum = 0;
        for(int i = 1; i<prices.length;++i){
            if (prices[i]>prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }
}
